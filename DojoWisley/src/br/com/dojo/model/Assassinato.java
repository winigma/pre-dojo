package br.com.dojo.model;

import java.io.Serializable;
import java.util.Date;

public class Assassinato implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7319741672004535782L;
    private Long idAssasinato;
    private Date data;
    private Jogador assassino;
    private Jogador morto;
    private Arma armaAssassino;

    public Assassinato() {
	// No-op
    }

    public Assassinato(Date data, Jogador assassino, Jogador morto,
	    Arma armaAssassino) {
	this.data = data;
	this.assassino = assassino;
	this.morto = morto;
	this.armaAssassino = armaAssassino;
    }

    @Override
    public String toString() {
	return this.assassino + " matou " + this.morto + " com "
		+ this.armaAssassino;
    }

    public Long getIdAssasinato() {
        return idAssasinato;
    }

    public void setIdAssasinato(Long idAssasinato) {
        this.idAssasinato = idAssasinato;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Jogador getAssassino() {
        return assassino;
    }

    public void setAssassino(Jogador assassino) {
        this.assassino = assassino;
    }

    public Jogador getMorto() {
        return morto;
    }

    public void setMorto(Jogador morto) {
        this.morto = morto;
    }

    public Arma getArmaAssassino() {
        return armaAssassino;
    }

    public void setArmaAssassino(Arma armaAssassino) {
        this.armaAssassino = armaAssassino;
    }

}
