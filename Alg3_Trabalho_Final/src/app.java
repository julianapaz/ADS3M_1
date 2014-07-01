import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class app {

	public static Vertice[] vertices = new Vertice[50];
	
	public static MatrizAdjacencias arestas;

	public static void main(String[] args) throws IOException 
	{
		FileInputStream arquivo = new FileInputStream("grafo.txt");
		carregaArquivo(new Scanner(arquivo));
		arquivo.close();
	}

	public static void carregaArquivo(Scanner arquivo)
	{

		String leituraAtual = arquivo.next();
		int id = -1;
		double coordenadaX = -1.0;
		double coordenadaY = -1.0;
	
		while ( !arquivo.hasNext("arestas") ) 
		{			

			leituraAtual = arquivo.next();
			id = Integer.parseInt(leituraAtual);

			leituraAtual = arquivo.next();
			coordenadaX = Double.parseDouble(leituraAtual);

			leituraAtual = arquivo.next();
			coordenadaY = Double.parseDouble(leituraAtual);

			vertices[id] = new Vertice(id, coordenadaX, coordenadaY);
			
		}

		arestas = new MatrizAdjacencias(vertices.length);
		Aresta aresta;

		double custo = -1;
		int linha = -1, coluna = -1;
		arquivo.next();
	
		while ( arquivo.hasNext() )
		{
			leituraAtual = arquivo.next();
			linha = Integer.parseInt(leituraAtual);

			leituraAtual = arquivo.next();
			coluna = Integer.parseInt(leituraAtual);


			leituraAtual = arquivo.next();
			custo = Double.parseDouble(leituraAtual);
			
			aresta = new Aresta(vertices[linha], vertices[coluna], custo);			
			
			arestas.setAresta(linha, coluna, aresta);
			arestas.setAresta(coluna, linha, aresta);

		}
		
		arquivo.close();
		arestas.print();
	}
	
	public void algoritmo()
	{
		boolean[] vistitados = new boolean[vertices.length];
		int[] anteriores = new int[vertices.length];
		double[] custo = new double[vertices.length];
		
		Stack s = new Stack();
		
		s.push(1);
		
		int x = -1;
		
		
		while ( !s.empty() )
		{
			x = (int) s.pop();
			
			if ( vertices[x].foiVisitado() )
			{
				Stack conectados = new Stack<>();
				conectados = verticesConectados(x);
				s.push(conectados.pop());
				
			}
		}		
	}
	
	public Stack verticesConectados(int vertice)
	{
		Stack conectados = new Stack();
		
		for ( int c = 0; c<vertices.length; c++)
		{
			for ( int l = 0; l<vertices.length; l++)
			{
				if (c == vertice && !vertices[l].equals(null))
					conectados.push(l);
			}
		}
		
		return conectados;
		
	}
	
	
	
}