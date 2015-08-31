package br.com.dojo.model;

import java.util.regex.Pattern;

public enum TipoLinha {

    INICIO_PARTIDA(
	    "^([\\w/]+\\s[\\w:]+) (-) (New match) ([0-9]{5,20}) (has started)"), JOGADOR_MATA_JOGADOR(
	    "^([\\w/]+\\s[\\w:]+) (-) ([\\w]+) (killed) ([\\w]+) (using) ([\\w]+)"), MUNDO_MATA_JOGADOR(
	    "^([\\w/]+\\s[\\w:]+) (-) (<WORLD>) (killed) ([\\w]+) (by) ([\\w]+)"), FIM_PARTIDA(
	    "^([\\w/]+\\s[\\w:]+) (-) (Match) ([0-9]{5,20}) (has ended)");

    private String grupoRegex;
    private Pattern pattern;

    private TipoLinha(String grupoRegex) {
	this.grupoRegex = grupoRegex;
	this.pattern = Pattern.compile(grupoRegex, Pattern.CASE_INSENSITIVE);
    }

    public String getGrupoRegex() {
	return grupoRegex;
    }

    public Pattern getPattern() {
	return pattern;
    }
}
