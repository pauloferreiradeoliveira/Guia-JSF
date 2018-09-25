package br.com.paulo.bean.estudante;

import br.com.paulo.model.Estudante;

import javax.el.LambdaExpression;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Bean do Registar Estudante
 * @author  Paulo Ferreira
 * Data 16/09/2018
 */

@Named
@ViewScoped
public class RegistarEstudanteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Boolean mostarNotas = false;

	private String[] nomes = {"Paulo","Ferreira","Oliveira"};

	private Set<String> nomesSet = new HashSet<String>(Arrays.asList("Paulo","Ferreira","Oliveira"));
	
	private Estudante estudante;

	public void  calcularCubo(LambdaExpression le, Long value){
		Long result =(Long) le.invoke(FacesContext.getCurrentInstance().getELContext(),value);
	}

	public  void excultar(String param){
        System.out.print("Consultado Banco de Dados" + param);
    }

    public String irPrincipal(){
	    return "principal";
    }
	public RegistarEstudanteBean (){

		estudante = new Estudante();
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}


	public String[] getNomes() {
		return nomes;
	}

	public void setNomes(String[] nomes) {
		this.nomes = nomes;
	}

    public Set<String> getNomesSet() {
        return nomesSet;
    }

    public void setNomesSet(Set<String> nomesSet) {
        this.nomesSet = nomesSet;
    }


	public Boolean getMostarNotas() {
		return mostarNotas;
	}

	public void setMostarNotas(Boolean mostarNotas) {
		this.mostarNotas = mostarNotas;
	}

	public void exibirNotas(){

		this.mostarNotas = !this.mostarNotas;
	}
}
