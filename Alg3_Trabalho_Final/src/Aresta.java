
public class Aresta {
	
	public int tamanho;
	public double[][] matriz;
	
	public Aresta(int tamanho)
	{
		this.tamanho = tamanho;
		
		matriz = new double[tamanho][tamanho];
	}
	
	public void setAresta(int linha, int coluna, double valor)
	{
		matriz[linha][coluna] = valor;
	}
	
	public double getAresta(int coluna, int linha)
	{
		return matriz[coluna][linha];
		
	}
	
	public void print()
	{
		System.out.println("\t");
		for ( int linha =0; linha<tamanho; linha++)
		{
			if ( linha == 0 )
				System.out.print("\t");
			System.out.print(linha+"\t");
		
		}
		System.out.println("\t");
	for ( int coluna=0; coluna < tamanho; coluna++ )
	{

		System.out.print(coluna + "\t");
		for ( int linha=0; linha <tamanho; linha++ )
		{
			System.out.print(matriz[linha][coluna] + "\t");
		}
		System.out.println();
	}
	}

}
