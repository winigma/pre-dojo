package br.com.dojo.model.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.dojo.model.LogPartidaCommon;
import br.com.dojo.model.Partida;
import br.com.dojo.model.TipoLinha;

public class InicioPartidaParser extends Parser<Partida> implements LogPartidaCommon{

	@Override
	public Partida parse(String linha, Partida partidaAtual) {
		
		Partida partida = null;
		
		try{
			Pattern p = TipoLinha.INICIO_PARTIDA.getPattern();
			Matcher m = p.matcher(linha);
			if(m.find()) {
				Date dataInicioPartida = dateUtil.getData( m.group(1) ); 
				
				Long idPartida = Long.parseLong( m.group(4) );
				
				
				partida = new Partida(idPartida, dataInicioPartida);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return partida;
	}

}
