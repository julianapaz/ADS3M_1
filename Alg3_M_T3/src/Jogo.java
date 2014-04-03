
public class Jogo {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro();
		PortaAvioes portaAvioes = new PortaAvioes();
		Jogador jogador = new Jogador("Juliana", 15);
		
		while(!jogador.perdeu() && !portaAvioes.destruido())
		{
			tabuleiro.print();
			tabuleiro.setPosicao(1, 1, 'o');
			tabuleiro.print();
			//sorteia posicao navio
			//verifica espaco disponivel para tamanho do navio
			//insere na matriz
			//imprime tabuleiro
			//entrada de coordenadas
			//testa se tem um pedaco de um navio
				//se sim
					//jogador ganho ponto
					//navio perde um pedaco
			
			
			jogador.perdePonto();
			jogador.perdePonto();
			jogador.perdePonto();
			jogador.perdePonto();
			jogador.perdePonto();
		}
	}
}
