import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.omg.CORBA.DoubleHolder;


public class app {

	public static Nodo vertice;
	public static Aresta arestas;

	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) throws IOException 
	{
		FileInputStream arquivo = new FileInputStream("grafo.txt");
		carregaArquivo(new Scanner(arquivo));
		arquivo.close();
	}

	public static void carregaArquivo(Scanner arquivo)
	{

		String leituraAtual = arquivo.next();
		int id=-1;
		double coordenadaX=-1.0;
		double coordenadaY=-1.0;
		//String s = arquivo.next();
		//System.out.println(s);

		while ( !arquivo.hasNext("arestas")) 
		{			

			leituraAtual = arquivo.next();
			id = Integer.parseInt(leituraAtual);

			leituraAtual = arquivo.next();
			coordenadaX = Double.parseDouble(leituraAtual);

			leituraAtual = arquivo.next();
			coordenadaY = Double.parseDouble(leituraAtual);


			vertice = new Nodo(id, coordenadaX, coordenadaY);

			//insere na estrutura
			System.out.println(vertice);
		}

		//metodo que retorna o total de vertices e declara a matriz de arestas
		arestas = new Aresta(50);

		double custo = -1;
		int linha = -1, coluna = -1;
		arquivo.next();
		while ( arquivo.hasNext())
		{
			leituraAtual = arquivo.next();
			linha = Integer.parseInt(leituraAtual);

			leituraAtual = arquivo.next();
			coluna = Integer.parseInt(leituraAtual);


			leituraAtual = arquivo.next();
			custo = Double.parseDouble(leituraAtual);

			arestas.setAresta(linha, coluna, custo);
			arestas.setAresta(coluna, linha, custo);

		}
		arquivo.close();
		arestas.print();
	}
}