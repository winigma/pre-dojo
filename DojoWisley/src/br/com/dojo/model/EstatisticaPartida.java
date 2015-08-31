package br.com.dojo.model;

import java.util.Set;

public interface EstatisticaPartida {

	public HistoricoSequenciaAssassinatosConsecutivos getJogadorComMaiorNumeroDeMortesConsecutivas();
	public int getQuantidadeAssassinatos(Jogador jogador);
	public int getQuantidadeMortes(Jogador jogador);
	public int getQuantidadePremios(Jogador jogador);
	public Arma getArmaFavoritaVencedor(Jogador jogador);
	public Set<Jogador> getVencedores();
	public Long getIdPartida();
	public Set<Jogador> getJogadoresDaPartida();
	
}
