package br.com.dojo.controller;

import java.util.Collection;
import java.util.HashSet;

import br.com.dojo.model.EstatisticaPartida;
import br.com.dojo.model.LogParser;
import br.com.dojo.model.Partida;

public class PartidaParserImpl implements LogParser<Partida, EstatisticaPartida>{

	@Override
	public Collection<EstatisticaPartida> parse(Collection<Partida> partidas){
		Collection<EstatisticaPartida> estatisticaPartidas = new HashSet<EstatisticaPartida>();
		try{
			
			for (Partida partida : partidas) {
				EstatisticaPartida estatisticaPartida = parse(partida);
				estatisticaPartidas.add(estatisticaPartida);
			}
			
		}catch(Exception e){
			String erroMsg = "Nao foi possível gerar as estatistícas.";
			e.printStackTrace();
		}
		
		return estatisticaPartidas;
	}
	
	@Override
	public EstatisticaPartida parse(Partida partida){
		EstatisticaPartida estatisticaPartida = null;
		try{
			
			estatisticaPartida = new EstatisticaPartidaMemoryImpl(partida);
			
		}catch(Exception e){
			String erroMsg = "Nao foi possível gerar a estatística.";
			e.printStackTrace();
		}
		
		return estatisticaPartida;
	}
	
}
