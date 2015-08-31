package br.com.dojo.model.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.dojo.model.Arma;
import br.com.dojo.model.Assassinato;
import br.com.dojo.model.Jogador;
import br.com.dojo.model.LogPartidaCommon;
import br.com.dojo.model.Partida;
import br.com.dojo.model.TipoLinha;

public class JogadorMataJogadorParser extends Parser<Assassinato> implements LogPartidaCommon{

	@Override
	public Assassinato parse(String linha, Partida partidaAtual) {
		
		Assassinato assasinato = null;
		try{
			Pattern p = TipoLinha.JOGADOR_MATA_JOGADOR.getPattern();
			Matcher m = p.matcher(linha);
			if( m.find() ) {
				Date data = dateUtil.getData( m.group(1) ); 
				//String separador = m.group(2);
				Jogador jogadorAssasino = new Jogador( m.group(3) );
				//String informacaoMatou = m.group(4);
				Jogador jogadorMorto = new Jogador( m.group(5) );
				//String informacaoAcao = m.group(6);
				Arma armaAssasino = new Arma( m.group(7) );
				
				assasinato = new Assassinato(data, jogadorAssasino, jogadorMorto, armaAssasino);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return assasinato;
	}

}
