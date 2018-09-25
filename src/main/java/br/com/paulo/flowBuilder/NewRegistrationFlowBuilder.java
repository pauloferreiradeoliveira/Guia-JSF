package br.com.paulo.flowBuilder;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

public class NewRegistrationFlowBuilder implements Serializable {

    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder){
        String flowId="newregistration";

        flowBuilder.id("",flowId);
        flowBuilder.viewNode(flowId,"/newregistration/newregistration.xhtml").markAsStartNode();
        flowBuilder.viewNode(flowId,"/newregistration/newregistration2.xhtml");
        flowBuilder.viewNode(flowId,"/newregistration/newregistration3.xhtml");
        flowBuilder.switchNode("newRegistrationPage2")
                .defaultOutcome(flowId)
                .switchCase()
                .condition("#{not empty testFlowBuilderBean.nome and not empty testFlowBuilderBean.sobrenome}")
                .fromOutcome("newregistration2");
        flowBuilder.returnNode("exitToInicio").fromOutcome("/inicioflow.xhtml");
        flowBuilder.returnNode("exitToIndex").fromOutcome("/index.xhtml");
        flowBuilder.flowCallNode("callNewPendencies")
                .flowReference("","newpendecies")
                .outboundParameter("userName","#{testFlowBuilderBean.nome}")
                .outboundParameter("userSurname","#{testFlowBuilderBean.sobrenome}");
        flowBuilder.finalizer("#{testFlowBuilderBean.sakvar()}");

        return  flowBuilder.getFlow();
    }
}
