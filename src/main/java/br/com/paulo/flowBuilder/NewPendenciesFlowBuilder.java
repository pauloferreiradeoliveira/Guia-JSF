package br.com.paulo.flowBuilder;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

public class NewPendenciesFlowBuilder implements Serializable {
    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "newpendecies";

        flowBuilder.id("",flowId);
        flowBuilder.viewNode(flowId,"/newpendecies/newpendecies.xhtml").markAsStartNode();
        flowBuilder.returnNode("proceedToNewRegistration3").fromOutcome("/newregistration/newregistration3.xhtml");
        flowBuilder.returnNode("exitToNewInicio").fromOutcome("/newregistration/newregistration.xhtml");
        flowBuilder.inboundParameter("userName","#{testFlowBuilderNested.userName}");
        flowBuilder.inboundParameter("userSurname","#{testFlowBuilderNested.surname}");

        return flowBuilder.getFlow();
    }
}
