package br.com.dojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import br.com.dojo.model.util.StatusPartida;

public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idPartida;
    private Date dataInicio;
    private Date dataFim;
    private Set<Assassinato> assassinatos = new LinkedHashSet<Assassinato>();

    public Partida(Long idPartida, Date dataInicio) {
	this.idPartida = idPartida;
	this.dataInicio = dataInicio;
    }

    public Partida(Long idPartida) {
	this.idPartida = idPartida;
    }

    public Partida(Long idPartida, Date dataInicio, Date dataFim) {
	this.idPartida = idPartida;
	this.dataInicio = dataInicio;
	this.dataFim = dataFim;
    }

    public StatusPartida getStatusPartida() {
	StatusPartida statusPartida = null;
	if (dataInicio != null && dataFim != null) {
	    statusPartida = StatusPartida.FINALIZADA;
	} else if (dataInicio != null) {
	    statusPartida = StatusPartida.INICIADA;
	} else {
	    statusPartida = StatusPartida.NAO_INICIOU;
	}

	return statusPartida;
    }

    @Override
    public String toString() {
	return "ID: " + this.idPartida + " INICIO:" + dataInicio + " FIM:"
		+ dataFim;
    }

    public Long getIdPartida() {
	return idPartida;
    }

    public void setIdPartida(Long idPartida) {
	this.idPartida = idPartida;
    }

    public Date getDataInicio() {
	return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
	this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
	return dataFim;
    }

    public void setDataFim(Date dataFim) {
	this.dataFim = dataFim;
    }

    public Set<Assassinato> getAssassinatos() {
        return assassinatos;
    }

    public void setAssassinatos(Set<Assassinato> assassinatos) {
        this.assassinatos = assassinatos;
    }

}
