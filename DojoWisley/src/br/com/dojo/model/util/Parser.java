package br.com.dojo.model.util;

import java.io.Serializable;

import br.com.dojo.model.Partida;


public abstract class Parser<R extends Serializable> {
	public abstract R parse(String linha, Partida partidaAtual);
}
