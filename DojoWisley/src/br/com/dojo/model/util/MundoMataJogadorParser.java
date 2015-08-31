package br.com.dojo.model.util;

import br.com.dojo.model.Assassinato;
import br.com.dojo.model.Partida;

public class MundoMataJogadorParser extends Parser<Assassinato> {

	@Override
	public Assassinato parse(String linha, Partida partidaAtual) {
		//Deve ser desconsiderado
		return null;
	}

}
