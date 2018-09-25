package br.com.paulo.bean.conversetion;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Named
@ConversationScoped
public class testConversetionBean implements Serializable {

    private List<String> personagens;
    private List<String> personagensSelecionado = new ArrayList<String>();

    public void selecionarPersonagen(){
        int index = new Random().nextInt(3);
        String personagem = getPersonagens().get(index);
        getPersonagensSelecionado().add(personagem);
    }

    @Inject
    private Conversation conversation;

    @PostConstruct
    public  void init(){
        personagens  = Arrays.asList("Yusuke","Biel","Kurana");
        if(conversation.isTransient()){
            conversation.begin();
        }

    }

    public void endConvevation(){
        if(!conversation.isTransient()){
            conversation.end();
        }

    }

    public List<String> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<String> personagens) {
        this.personagens = personagens;
    }

    public List<String> getPersonagensSelecionado() {
        return personagensSelecionado;
    }

    public void setPersonagensSelecionado(List<String> personagensSelecionado) {
        this.personagensSelecionado = personagensSelecionado;
    }
}
