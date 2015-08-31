package br.com.dojo.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Set;

import br.com.dojo.controller.ExibeDadosEstatisticaPartidaConsoleImpl;
import br.com.dojo.controller.LeitorLogPartidaImpl;
import br.com.dojo.controller.PartidaParserImpl;
import br.com.dojo.model.EstatisticaPartida;
import br.com.dojo.model.ExibeDados;
import br.com.dojo.model.LeitorLog;
import br.com.dojo.model.LogParser;
import br.com.dojo.model.Partida;

public class Executor {

	public static void main(String[] args) {
		try {
			
			imprimirMenuAjuda();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			
	        while (true) {  
	        	
	        	String comando = reader.readLine();  
	        	if("ajuda".equals(comando)){
	        		imprimirMenuAjuda();
	        	}else if("sair".equals(comando)){
	        		break;
	        	}else{
	        		leArquivo( comando.replace("\\", "/") );
	        	}
	        } 
	        
	        System.out.println("Aplicação finalizada com sucesso");
		} catch(Exception e){
			String erroMsg = e.getMessage();
			e.printStackTrace();
			System.out.println("Erro: " + erroMsg);
		} 
	}

	private static void imprimirMenuAjuda() {
		System.out.println("============================ Options ===============================");
		System.out.println(" 'sair': sair do programa                                       ");
	        System.out.println("= '/nome/arquivo.log': Ler log     ");
	}

	public static void leArquivo(String caminhoArquivo) throws IOException{
	    
		File logFile = new File(caminhoArquivo);
		if(logFile.isFile()){
			System.out.println("Lendo arquivo: " + caminhoArquivo);  
			LeitorLog<Partida> analisadorDeLogPartida = new LeitorLogPartidaImpl(logFile);
			Set<Partida> partidasAnalisadas = analisadorDeLogPartida.processaLog();
			
			LogParser<Partida, EstatisticaPartida> geraEstatisticaPartidas = new PartidaParserImpl();
			Collection<EstatisticaPartida> estatisticasPartidas = geraEstatisticaPartidas.parse(partidasAnalisadas);
			
			ExibeDados<EstatisticaPartida> exibeDadosEstatisticaPartida = new ExibeDadosEstatisticaPartidaConsoleImpl();
			exibeDadosEstatisticaPartida.exibirDados(estatisticasPartidas);
		}else{
			System.out.println("Arquivo inválido: " + caminhoArquivo); 
		}
	}
}
