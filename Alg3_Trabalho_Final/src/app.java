import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class app {

	//vetor de vertices
	public static Vertice[] vertices = new Vertice[50];
	
	//matriz formada por arestas
	public static MatrizAdjacencias arestas;

	public static void main(String[] args) throws IOException 
	{

		FileInputStream arquivo = new FileInputStream("grafoTeste.txt");
		carregaArquivo(new Scanner(arquivo));
		arquivo.close();

		algoritmo();
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
		//arestas.print();
		
	//	verticesConectados(1);
		
	}
	
	public static void algoritmo()
	{	
		//pilha dos vertices
		Stack<Integer> s = new Stack<Integer>();
		
		//insere um valor incial na pilha
		s.push(vertices[0].getIdentificador());
		
		//indice atual
		int x = -1;
		
		//enquanto a pilha nao for vazia
		while ( !s.empty() )
		{
			//x recebe o topo
			x = s.pop();
			
			//se o vertice nao foi visitado
			if ( !vertices[x].visitado() )
			{
				//pilha com todos os vertices alcancaveis
				Stack<Integer> conectados = new Stack<Integer>();
				//pilha que recebe todos os vertices alcancaveis por x
				conectados = verticesConectados(x);
				
				//enquanto pilha nao estiver vazia
				while ( !conectados.empty() )
				{
					
					double c = vertices[conectados.peek()].getCusto();
					
					//calcula custo
					//atualiza vertices
					//atualiza anterior
					vertices[conectados.peek()].setAnterior(x);
				
					if ( !vertices[(int) conectados.peek()].visitado() )
						s.push(conectados.pop());
					
					vertices[x].setVisitado(true);
				}
			}

			else
				s.pop();
		}		
	}
	
	// ok - testado
	public static Stack<Integer> verticesConectados(int vertice)
	{
		Stack<Integer> conectados = new Stack<Integer>();
		//System.out.println(vertices.length);
		
		for ( int c = 0; c<vertices.length; c++)
		{
			if ( c == vertice )
			{
				for ( int l = 0; l<vertices.length; l++)
				{
					if ( arestas.getAresta(c,l) != null )
					{
						/*System.out.print("Conectado: ");
						System.out.print(c);
						System.out.print(" ");
						System.out.println(l);*/
						conectados.push(l);
					}
				}
				break;
			}
			/*while ( !conectados.isEmpty() )
				System.out.println(conectados.pop());*/
		}
		return conectados;
	}
	
	
	
}