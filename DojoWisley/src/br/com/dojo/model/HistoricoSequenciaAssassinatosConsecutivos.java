package br.com.dojo.model;

public class HistoricoSequenciaAssassinatosConsecutivos {

    private Jogador assassino;
    private Integer numeroAssassinatosConsecutivos;

    public HistoricoSequenciaAssassinatosConsecutivos() {
	// No-op
    }

    public HistoricoSequenciaAssassinatosConsecutivos(Jogador assassino,
	    Integer numeroAssassinatosConsecutivos) {
	this.assassino = assassino;
	this.numeroAssassinatosConsecutivos = numeroAssassinatosConsecutivos;
    }

    public Jogador getAssassino() {
        return assassino;
    }

    public void setAssassino(Jogador assassino) {
        this.assassino = assassino;
    }

    public Integer getNumeroAssassinatosConsecutivos() {
        return numeroAssassinatosConsecutivos;
    }

    public void setNumeroAssassinatosConsecutivos(
    	Integer numeroAssassinatosConsecutivos) {
        this.numeroAssassinatosConsecutivos = numeroAssassinatosConsecutivos;
    }
}
