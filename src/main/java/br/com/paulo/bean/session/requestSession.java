package br.com.paulo.bean.session;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
* Session quarda até fechar Browser
* */
@Named
@SessionScoped
public class requestSession implements Serializable {
    private List<String> personagens;
    private List<String> personagensSelecionado = new ArrayList<String>();

    public void selecionarPersonagen(){
        int index = new Random().nextInt(4);
        String personagem = getPersonagens().get(index);
        getPersonagensSelecionado().add(personagem);
    }

    @PostConstruct
    public  void init(){
        personagens  = Arrays.asList("Yusuke","Biel","Kurana","Goku");
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "session?faces-redirect=truee";
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
