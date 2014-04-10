import java.util.Scanner;
import static java.lang.System.out;

public class Jogo {
	
	public static final int VAZIO = -1;
	public static final int TIRO = -2;
	public static final char ACERTO = 'O';
	public static final char ERRO = '-';
	public static final int PONTOS_MAX = 5;
	public static final int PONTOS_MIN = 3;
	public static final int PONTOS_INICIAIS = 15;
	
	public static void main(String[] args) 
	{
		
		Tabuleiro tabuleiro = new Tabuleiro();
		
		Jogador jogador = new Jogador("Juliana", PONTOS_INICIAIS);
		
		int linha, coluna;
		Scanner entrada = new Scanner(System.in);
						
		while(!jogador.perdeu() && tabuleiro.getTotalNavios()>0)
		{
			//tabuleiro.print();
			tabuleiro.printDesenhoTabuleiro();
			out.println("Pontos Jogador "+jogador.getNome() +": " +jogador.getTotalPontos());
			out.println("Total Navios: "+tabuleiro.getTotalNavios());
			//out.println(tabuleiro.getPosicao(1, 1));
			out.println("Digite a linha:");
			linha = leLinha(entrada.next().toLowerCase());
			
			out.println("Digite a coluna:");
			coluna = entrada.nextInt();
			coluna --;
			
			if(tabuleiro.getPosicao(linha, coluna) != VAZIO)
			{
				if(tabuleiro.getPosicao(linha, coluna) != TIRO)
				{
					//insere marcado no tabuleiro visao jogador
					tabuleiro.setPosicaoDesenhoTabuleiro(linha, coluna, ACERTO);
				
					//dispara no pedaco do navio
					tabuleiro.dispara(tabuleiro.getPosicao(linha, coluna));
				
					//se o navio foi destruido
				
				//	out.println("retorno get posicao: "+tabuleiro.getPosicao(linha, coluna));
				
					if(tabuleiro.navioDestruido(tabuleiro.getPosicao(linha, coluna)))
						//jogardor ganho ponto maximo
						jogador.ganhaPonto(PONTOS_MAX);
					//senao
					else
						//jogador ganha ponto minimo
						jogador.ganhaPonto(PONTOS_MIN);
				
					tabuleiro.setPosicao(linha, coluna, TIRO);
				}
			}
			else
			{
				tabuleiro.setPosicaoDesenhoTabuleiro(linha, coluna, ERRO);
				jogador.perdePonto();
			}
			//tabuleiro.mostraPedacos();
			
				
		}
		
		if(jogador.perdeu())
			out.println(jogador.getNome() + ", voce perdeu!");
		else
			out.println(jogador.getNome() + ", voce ganhou!");
		


	}
	
	public static int leLinha(String  letra)
	{
		int linha;
		
		switch (letra.charAt(0)) {
		case 'a':
			linha = 0;
			break;
			
		case 'b':
			linha = 1;
			break;
		
		case 'c':
			linha = 2;
			break;
			
		case 'd':
			linha = 3;
			break;
			
		case 'e':
			linha = 4;
			break;
			
		case 'f':
			linha = 5;
			break;
			
		case 'g':
			linha = 6;
			break;
			
		case 'h':
			linha = 7;
			break;
			
		case 'i':
			linha = 8;
			break;
			
		case 'j':
			linha = 9;
			break;
		
	
		default:
			linha = 9;
			break;
		}
		
		return linha;
	}
	
}
