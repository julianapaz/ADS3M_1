import java.util.Scanner;
import static java.lang.System.out;

public class Jogo {
	
	public static void main(String[] args) 
	{
		
		Tabuleiro tabuleiro = new Tabuleiro();
		
		Jogador jogador = new Jogador("Juliana", 15);
		
		int linha, coluna;
		Scanner entrada = new Scanner(System.in);
		
		int vazio=-1, tiro=-2;
		char acerto = 'O', erro = '-';
		int pontosMax = 5, pontosMin = 3;
				
		while(!jogador.perdeu() && tabuleiro.getTotalNavios()>0)
		{
			tabuleiro.print();
			tabuleiro.printDesenhoTabuleiro();
			out.println("Pontos Jogador "+jogador.getNome() +": " +jogador.getTotalPontos());
			out.println("Total Navios: "+tabuleiro.getTotalNavios());
			//out.println(tabuleiro.getPosicao(1, 1));
			out.println("Digite a linha:");
			linha = leLinha(entrada.next().toLowerCase());
			
			out.println("Digite a coluna:");
			coluna = entrada.nextInt();
			coluna --;
			
			if(tabuleiro.getPosicao(linha, coluna) != vazio)
			{
				if(tabuleiro.getPosicao(linha, coluna) != tiro)
				{
					//insere marcado no tabuleiro visao jogador
					tabuleiro.setPosicaoTabuleiroPrint(linha, coluna, acerto);
				
					//dispara no pedaco do navio
					tabuleiro.dispara(tabuleiro.getPosicao(linha, coluna));
				
					//se o navio foi destruido
				
				//	out.println("retorno get posicao: "+tabuleiro.getPosicao(linha, coluna));
				
					if(tabuleiro.navioDestruido(tabuleiro.getPosicao(linha, coluna)))
						//jogardor ganho ponto maximo
						jogador.ganhaPonto(pontosMax);
					//senao
					else
						//jogador ganha ponto minimo
						jogador.ganhaPonto(pontosMin);
				
					tabuleiro.setPosicao(linha, coluna, tiro);
				}
			}
			else
			{
				tabuleiro.setPosicaoTabuleiroPrint(linha, coluna, erro);
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
