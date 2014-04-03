import static java.lang.System.out;
public class Tabuleiro {
	
		private char[][] posicao = new char[10][10];
		
		/*public char getPosicao(int linha, int coluna) {
			return posicao[linha][coluna];
		}*/

		public void setPosicao(int linha, int coluna, char marcador) {
			this.posicao[linha][coluna] = marcador;
		}

		public Tabuleiro()
		{
			
			int i,j;
			for(i=0;i<10;i++)
			{
				for(j=0;j<10;j++)
				{
					posicao[i][j]='.';
				}
			}
					
		}
		
		public void print()
		{
			char linha = 'A';
			int coluna = 1;
			int i, j;
			out.print(" ");
			
			for(coluna=1;coluna<=10;coluna++)
				out.print(coluna + " ");
			
			out.println();
			for(i=0;i<10;i++)
			{
				out.print(linha + " ");
				for(j=0;j<10;j++)
				{
					
					out.print(posicao[i][j] + " ");
				}
				out.println();
				linha++;
			}
			
		}
}
