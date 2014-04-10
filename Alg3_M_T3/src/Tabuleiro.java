import static java.lang.System.out;

import java.util.Random;
public class Tabuleiro 
{
	
		
		//declarar constantes				
		int nrPortaAvioes = 1;
		int nrDestroyers = 2;
		int nrFragatas = 2;
		int nrTorpedos = 3;
		int nrSubmarinos = 5;
		int totalNavios=13;
		int vazio = -1;
		
		private Navio[] navios = new Navio[totalNavios];
		private int[][] posicao = new int[10][10];
		private char[][] print = new char[10][10];
		private int indiceAtual = 0;
				
		
		/**
		 * Metodo que retorna o nr de navios que ainda nao foram destruidos
		 * @return total de navios - como que comenta o return?
		 */
		public int getTotalNavios()
		{
			int totalDestruidos=0;
			
			for(int i=0; i<totalNavios; i++)
				if(!navios[i].destruido())
					totalDestruidos++;
						
			return totalDestruidos;
		}
		
		/**
		 * @deprecated so para teste
		 * ver a quantidade de partes de cada navio 
		 */
		public void mostraPedacos()
		{
			for(int i=0; i<totalNavios; i++)
				out.println("Indice: " + i+ " " + navios[i] + " pedacos restantes: " + navios[i].getPedacos());
		}
		
		/**
		 * Metodo que insere um inteiro na coordenada(linha, coluna)
		 * @param linha
		 * @param coluna
		 * @param nrNavio
		 */
		public void setPosicao(int linha, int coluna, int nrNavio) {
			posicao[linha][coluna] = nrNavio;
		}
		
		
		/**
		 * Metodo que retorna o que esta armazenado na posicao(linha, coluna)
		 * @param linha
		 * @param coluna
		 * @return
		 */
		public int getPosicao(int linha, int coluna)
		{
			return posicao[linha][coluna];
		}

		/**
		 * Construtor do tabuleiro
		 * insere os Navios, a quantidade de partes e quantidade de cada um
		 */
		public Tabuleiro()
		{
			
			/*Realiza chamada de metodo, passando os parametros necessarios
			 * para inserir um novo navio
			 */			
			insereNovoNavio("Porta avioes",5, nrPortaAvioes);
			insereNovoNavio("Destroyer",4, nrDestroyers);
			insereNovoNavio("Fragata",3, nrFragatas);
			insereNovoNavio("Torpedo",2, nrTorpedos);
			insereNovoNavio("Submarino",1, nrSubmarinos);
			
			//chamada do metodo que inicializa a matriz onde estarão
			//os indices relacionados a um navio
			carregaTabuleiroIndices();
			
			//chamada do metodo que inicializa a matriz que o jogador tera visao
			carregaDesenhoTabuleiro();
			
			//insere navios em um vetor de navio para
			//que seu indice seja associado a uma posicao
			//se repetindo pelo nr de partes que possui
			for(int i=0; i<totalNavios; i++)
			{				
				//recebe uma linha valida do metodo gerLinha
				geraLinha(navios[i], i);
			
				//chamada do metodo que insere o indice do navio na matriz
				//se repetindo pelo nr de partes que possui
				//insereNaPosicao(linha, coluna, i, navios[i].getTamanho());
			}
				
			
		}	
		/**
		 * Metodo que insere um novo Navio no vetor de Navios
		 * @param nome
		 * @param tamanho
		 * @param nrNavios
		 */
		public void insereNovoNavio(String nome, int tamanho, int nrNavios)
		{
	
			for(int i=0; i<nrNavios; i++)
				
			{
				navios[indiceAtual] = new Navio(nome, tamanho);
				indiceAtual ++;
			}
		}
		
		/*
		 * Metodo que gera uma coluna
		 * que comporte o nr de partes do navio
		 * 
		 */
		public int geraColuna(int tam)
		{
			Random r = new Random();
			int coluna = 10;
			
			coluna = 0 + r.nextInt(10-tam);
			//	out.println("Coluna sorteada: "+coluna);
			return coluna;
		}
		
		
		/**
		 * Metodo que gera uma linha valida
		 * que nao possua navio acima ou abaixo
		 * @param navio
		 * @return
		 */
		public void geraLinha(Navio navio, int indice)
		{
			//out.println("entrou no gera linha do " + navio.getNome());
			Random r = new Random();
			int linha = 0, coluna=0;
			int espacosDisponiveis = 0;
			
			while (espacosDisponiveis<navio.getTamanho())
			{
				//recebe uma coluna de 0 ate a coluna
				//de nr maximo que comporte o nr de partes do navio
				coluna = geraColuna(navio.getTamanho());
				//out.println("Coluna sorteada: "+coluna);
				
				//linha recebe um nr randomico de 0 a 9
				linha = 0 + r.nextInt(9);
								
				for (int i=coluna; i<coluna+(navio.getTamanho());i++)
				{
					//a posicao esta vazia
					if (posicao[linha][i] == vazio)
					{
						//se a linha eh 0, so verifica a linha 1 se esta vazia
						if (linha==0)
						{
							//verifica a linha 2 se esta vazia
							int linhaPos = linha+1;
							if (posicao[linha+1][i] == vazio)
									espacosDisponiveis++;
						}
						else if (linha==9)
						{
							//verifica a linha 8 se esta vazia
							int linhaAnt = linha-1;
							if (posicao[linha-1][i]== vazio)
									espacosDisponiveis++;
						}
						else
						{
							if (posicao[linha-1][i] == vazio)
							{
								int linhaAnt = linha-1;
							
								if (posicao[linha+1][i] == vazio)
								{
									int linhaPos = linha+1;
									espacosDisponiveis++;
								}
							}
						}
						
					}
				}
			}
			
			insereNaPosicao(linha, coluna, indice, navios[indice].getTamanho());
		}
		
		/**
		 * Metodo que retorna teste se navio destruido
		 * @param indice
		 * @return se navio esta destruido
		 */
		public boolean navioDestruido(int indice)
		{
			return navios[indice].destruido();
			
		}
		
			
		/**
		 * Metodo que insere o indice do navio na posicao o nr de vezes
		 * eh o nr de partes que o navio possui
		 * @param linha
		 * @param coluna
		 * @param indice
		 * @param tam
		 */
		public void insereNaPosicao(int linha, int coluna, int indice, int tam)
		{
			//out.println("Entrada tamanho: " + tam);
			for(int i=0; i<tam; i++)
			{
				posicao[linha][coluna] = indice;
				//out.println("Inseriu Valor: "+posicao[linha][coluna] +" na posicao "+linha + "," + coluna);
				//int valor = posicao[linha][coluna];
				//out.println("Valor: " + valor);
				coluna++;
			//	out.println("InsereNaPosicao coluna incrementada: "+ coluna);
			}
		}
		/**
		 * Metodo que inicializa a matriz que conterao os indices associados a um navio
		 * Inicializa com um nr que indica posicao vazia
		 */
		public void carregaTabuleiroIndices()
			{		
			int linha, coluna;
		//	int valor;
		
			for(linha=0; linha<10; linha++)
				for(coluna=0; coluna<10; coluna++)
				{
					posicao[linha][coluna] = vazio;
					//valor = posicao[linha][coluna];
				}
		}
		
		/**
		 * Metodo que dispara um tiro em um navio associado ao indice de entrada
		 * @param indice
		 */
		public void dispara(int indice){
			navios[indice].recebeTiro();
		}
		
		
		/**
		 * Mostra onde os navios e indices foram distribuidos
		 * @deprecated
		 */
		public void print()
		{
			char linha = 'A';
			int coluna = 1;
			int i, j;
			//out.print(" ");
			
			for (coluna=1;coluna<=10;coluna++)

				out.print("\t" + coluna);
		
			out.println();
			
			for (i=0;i<10;i++)
			{
				out.print(linha + " ");
				for (j=0;j<10;j++)
				{
						for (j=0;j<10;j++)
					{
						out.print("\t" + posicao[i][j]);

					}
				out.println();
				linha++;
			}
			
		}
	}
		/**
		 * Metodo que carrega com valores iniciais o
		 * tabuleiro que sera exibido para o jogador
		 */
		public void carregaDesenhoTabuleiro()
		{
			int l, c;
			
			for (l=0; l<10; l++)
				for (c=0; c<10; c++)
					print[l][c] = '.';
		}
		
		/**
		 * Metodo que altera o tabuleiro visao do jogador
		 * marcando a posicao onde foi feito o disparo
		 * o paramento marcador indica se acertou ou se errou uma
		 * das partes de um navio
		 * @param l
		 * @param c
		 * @param marcador
		 */
		public void setPosicaoTabuleiroPrint(int l, int c, char marcador)
		{
			print[l][c] = marcador;
		}
		
		public void printDesenhoTabuleiro()
		{
			char linha = 'A';
			int coluna = 1;
			int i, j;
			for (coluna=1;coluna<=10;coluna++)
				out.print("\t" + coluna);
			
			out.println();
			
			for (i=0;i<10;i++)
			{

				out.print(linha + " ");
				for (j=0;j<10;j++)
				{
					
					for (j=0;j<10;j++)
					{
						out.print("\t" + print[i][j]);

					}
				out.println();
				linha++;
			}
			
		}
					
		}
}
