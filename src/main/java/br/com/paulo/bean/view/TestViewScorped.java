package br.com.paulo.bean.view;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Named
@ViewScoped
public class TestViewScorped implements Serializable {

    private List<String> personagens;
    private List<String> personagensSelecionado = new ArrayList<String>();

    public void selecionarPersonagen(){
        int index = new Random().nextInt(4);
        String personagem = getPersonagens().get(index);
        getPersonagensSelecionado().add(personagem);
    }

    @PostConstruct
    public  void init(){
        personagens  = Arrays.asList("Yusuke","Biel","Kurana","Goku","Naruto");
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

