package br.com.dojo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;

import br.com.dojo.model.Assassinato;
import br.com.dojo.model.LeitorLog;
import br.com.dojo.model.LogParser;
import br.com.dojo.model.Partida;
import br.com.dojo.model.TipoLinha;
import br.com.dojo.model.util.Parser;

public class LeitorLogPartidaImpl extends LeitorLog<Partida>{

	private final File arquivo;
	private final static Charset ENCODING = StandardCharsets.UTF_8; 

	public LeitorLogPartidaImpl(File arquivo){
		this.arquivo = arquivo;
	}
	
	public final Set<Partida> processaLog() throws IOException {
		
		final Set<Partida> partidas = new HashSet<Partida>();
		Scanner scanner = null;	
		Partida partidaAtual = null;
		
		try{
			
			scanner = new Scanner(this.arquivo, ENCODING.name());
			while (scanner.hasNextLine()) {
				partidaAtual = processaLinha(scanner.nextLine(), partidaAtual);
				partidas.add(partidaAtual);
			}
			
		}catch(Exception e){
			String erroMsg = "Nao foi possivel procesar as linhas do arquivo.";
			e.printStackTrace();
		}finally{
			scanner.close();
		}
		
		return partidas;
	}

	@SuppressWarnings("rawtypes")
	private Partida processaLinha(String linha, Partida partidaAtual) {
		
		TipoLinha tipoLinha = getTipoDaLinha(linha);
		Parser parser = br.com.dojo.model.util.LogParser.getParser(tipoLinha);
		
		Object retorno = parser.parse(linha, partidaAtual);
		if(retorno != null){
			if(tipoLinha == TipoLinha.INICIO_PARTIDA || tipoLinha == TipoLinha.FIM_PARTIDA){
				partidaAtual = (Partida)retorno;
			}else if(tipoLinha == TipoLinha.JOGADOR_MATA_JOGADOR && partidaAtual != null){
				Assassinato assasinato = (Assassinato)retorno;
				partidaAtual.getAssassinatos().add(assasinato);
			}
		}

		return partidaAtual;
	}

	private TipoLinha getTipoDaLinha(String linha) {
		for (TipoLinha tipoLinha : TipoLinha.values()) {
			Matcher matcher = tipoLinha.getPattern().matcher(linha);
			if(matcher.matches()){
				return tipoLinha;
			}
		}
		
		return null;
	}
}