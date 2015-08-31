package br.com.dojo.model;

import java.io.Serializable;

public class Jogador implements Serializable{

   
    private static final long serialVersionUID = -1127118646236199130L;
    private String nome;
	
	public Jogador(){
	}
	
	public Jogador(String nome){
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
