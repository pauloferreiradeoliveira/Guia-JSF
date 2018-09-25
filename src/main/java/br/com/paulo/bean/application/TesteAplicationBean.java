package br.com.paulo.bean.application;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ApplicationScoped
public class TesteAplicationBean implements Serializable {
    private List<String> categoriasList;

    @PostConstruct
    public  void init(){
        this.categoriasList = Arrays.asList("RPG","SciFI","Terror");
    }

    public List<String> getCategoriasList() {
        return categoriasList;
    }

    public void setCategoriasList(List<String> categoriasList) {
        this.categoriasList = categoriasList;
    }
}
