package br.com.dojo.model;

public class Arma {
    private String nome;
	
	public Arma(){
		//No-op
	}
	
	public Arma(String nome){
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.nome;
	}

	public String getNome() {
	    return nome;
	}

	public void setNome(String nome) {
	    this.nome = nome;
	}

}
