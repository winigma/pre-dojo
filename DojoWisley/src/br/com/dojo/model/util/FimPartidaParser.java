package br.com.dojo.model.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.dojo.model.LogPartidaCommon;
import br.com.dojo.model.Partida;
import br.com.dojo.model.TipoLinha;

public class FimPartidaParser extends Parser<Partida> implements LogPartidaCommon{
	
	@Override
	public Partida parse(String linha, Partida partidaAtual){
		try{
			Pattern p = TipoLinha.FIM_PARTIDA.getPattern();
			Matcher m = p.matcher(linha);
			if(m.find()) {
				Date dataFimPartida = dateUtil.getData( m.group(1) );
				
				
				partidaAtual.setDataFim(dataFimPartida);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return partidaAtual;
	}

}
