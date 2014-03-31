package com.senac.aplicacao;

import static java.lang.System.out;

import java.awt.Dimension;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.senac.estruturas.ListaOrdenada;
import com.senac.estruturas.Nodo;

public class Aplicacao {

	private static ListaOrdenada<String> agenda = new ListaOrdenada<String>();
	private static final char MARCADOR = '*';
	//private static Contato novoContato = new Contato();
	private static String nome, telefone;
	private static Scanner entrada = new Scanner(System.in);

	/** Metodo principal 
	 * 
	 * @param args
	 * @throws Exception
	 */	
	public static void main(String[] args) throws Exception 
	{
		FileInputStream arquivo = new FileInputStream("agenda.txt");
		carregaAgenda(new Scanner(arquivo));
		arquivo.close();
		
		int opcao = -1;
		buscaBinaria();
		
		while (opcao != 0)
		{
			out.print("AGENDA \nDigite sua opcao \n" + "1-Cadastrar\n"
					+ "2-Buscar\n" + "3-Remover\n" + "4-Exibir lista\n"
					+ "0-Sair\n");
			opcao = entrada.nextInt();

			switch (opcao) 
			{
				case 1:
					cadatraNovoContato();
					break;

				case 2:
					buscaContato();
					break;
					
				case 3:
					buscaBinaria();
				
				case 4:
					removeContato();
					break;

				case 5:
					agenda.print();
					break;

				default:

					break;
			}

		}
		
	}
	
	/** Metodo que correga o arquivo txt para a lista, lendo contato por contato
	
	*@param recebe um arquivo txt como scanner*/
	private static void carregaAgenda(Scanner arquivo)
	{
		char nomeTeste;
		
		while (arquivo.hasNext()) 
		{	
			nome = arquivo.next();
			//novoContato.setNome(nome = arquivo.next());
			nomeTeste = nome.charAt(0);
			if(nomeTeste == MARCADOR)
				arquivo.next();
			else
			{
				telefone = arquivo.next();
				//novoContato.setTelefone(telefone = arquivo.next());
				//agenda.insert(new Nodo<>(novoContato.getNome(), novoContato.getTelefone()));
				agenda.insert(new Nodo<>(nome, telefone));
			}
		}
		arquivo.close();
	}

	/** Metodo que passa como paramentro a letra para busca no metodo findiInicial
	 *  Realiza chamada do metodo nageva 
	 */
	private static void buscaContato() 
	{
		String letra = null;

		out.println("Digite a letra inicial:");
		letra = entrada.next();

		//EXIBE O PRIMEIRO NOME ENCONTRADO NA LISTA
		out.println(agenda.findInicial(letra.charAt(0)));	
		
		navega(agenda.findInicial(letra.charAt(0)));
	}
	
	/** Metodo que mostra opcoes de navegao na agenda apos realizar a busca
	 *  Realiza chamadas de metodos avanca e retorna
	 * 
	 * @param nomeAtual - 
	 */	
	private static void navega(Nodo<String> nomeAtual)
	{
		int op = -1;
		//LACO PARA NAVEGAR NA AGENDA
		while (op != 0)
		{
			out.println("1)ANTERIOR    2)PROXIMO\n0 - VOLTAR AO MENU");
			op = entrada.nextInt();

			if (op == 1) 
			{
				nomeAtual = agenda.retorna(nomeAtual);
				out.println(nomeAtual);
			}

			if (op == 2)
			{
				nomeAtual = agenda.avanca(nomeAtual);
				out.println(nomeAtual);
			}
		}
	}

	/** Metodo que insere um novo contato na lista e chama o metodo que insere no arquivo
	 * 
	 * @throws IOException
	 */
	private static void cadatraNovoContato() throws IOException 
	{
		out.println("Digite o nome:");
		nome = entrada.next();

		out.println("Digite o telefone:");
		telefone = entrada.next();

		agenda.insert(new Nodo<>(nome, telefone));
		
		insereNoArquivo(nome, telefone);

	}
	
	/** Metodo que insere um novo contato cadastrado na lista 
	 * 
	 * @param nome
	 * @param telefone
	 * @throws IOException
	 */	
	public static void insereNoArquivo(String nome, String telefone) throws IOException
	{
		FileWriter arquivo = new FileWriter("agenda.txt", true);
		BufferedWriter agenda = new BufferedWriter(arquivo);

		agenda.write(nome + " " + telefone);
		agenda.newLine();
		agenda.flush();
		agenda.close();
	}
	
	/** Metodo que solicita o nome a ser excluido da lista, realiza a chamada de metodo que exclui o nome
	 * da lista e chama o metodo marcaNomeRemovido referente ao arquivo txt
	 * @throws Exception
	 */	
	public static void removeContato() throws Exception
	{
		out.println("Digite o nome para excluir");
		nome = entrada.next();
		marcaNomeRemovido(agenda.remove(nome));
	}
	
	/** Metodo utilizado apos a exclusao de um contato da lista
	 *  A lista era escrita no arquivo, o arquivo permanecia
	 * 	com os nomes ordenados exatamento como ordenados na lista
	 * @throws IOException
	 * @deprecated utilizado ate implementar o metodo que apenas insere um marcado no contato excluido da lista
	 */	
	public static void atualizaArquivo() throws IOException
	{
		FileWriter arquivo = new FileWriter("agenda.txt");

		BufferedWriter agendaW = new BufferedWriter(arquivo);
		Nodo<String> nodo = agenda.getHead();
		
		while (nodo != null)
		{
			String contato = nodo.getChave() + " " + nodo.getData();
			agendaW.write(contato);
			agendaW.newLine();
			nodo = nodo.getNext();
		}
		agendaW.flush();
		agendaW.close();
		
	}
	
	/** Metodo que marca o contato que foi excluido da lista
	 *  Metodo percorre linha por linha do arquivo comparando o contato excluido da lista
	 *  Um marcado eh inserido no contato 
	 *
	 * @param nodo - o contato que foi excluido da lista, o metodo percorre o arquivo linha por linha
	 * @throws IOException
	 */
	public static void marcaNomeRemovido(Nodo<String> nodo) throws IOException{
		
		BufferedWriter tmp = new BufferedWriter(new FileWriter("tmp.txt"));
		BufferedReader agendaLeitura = new BufferedReader(new FileReader("agenda.txt"));
      
		String linha;
        String contato = nodo.getChave() + " " + nodo.getData();
        
        //out.println("Nodo de entrada: "+ nodo);
        
       	while ((linha = agendaLeitura.readLine()) != null)
       	{
       		//out.println("Fora do if Linha: "+linha);
        	if (linha.contains(contato))
        	{
        		//out.println("Dentro do teste - Linha: "+linha+"Contato: "+contato);
        		linha = MARCADOR + contato;
        	}
        	
        	
        	tmp.write(linha);
        	tmp.newLine();
        }
       	
        tmp.flush();
        tmp.close();
        agendaLeitura.close();
                
        new File("agenda.txt").delete();
        new File("tmp.txt").renameTo(new File("agenda.txt"));
        
	}

	/** Metodo que realiza busca binaria
	 * Carrega a lista ordenada em um list com indice
	 */
	public static void buscaBinaria()
	{
		List lista = new List();
		int indice = 0;
				
		Nodo<String> nodo = agenda.getHead();
		
		while (nodo != null)
		{
			//insere o contato na lista com um indice associado
			lista.add(nodo.getChave(),indice);
			out.println("Nodo: " + nodo.getChave() + " " + indice);
			//incrementa o indice
			indice ++;
			//vai para o proximo nome
			nodo = nodo.getNext();
		}		
		
		//variavel que recebe a quantidade de nomes que a lista contem
		int tamanho = lista.countItems();
		//out.println(tamanho);
		
		//entrada do nome para busca
		out.println("Digite o nome para busca: ");
		nome = entrada.next();
	
		//inicializa o meio da lista
		int meio = (tamanho-1)/2;
		
		//inicializa o inicio e o fim da lista
		int inicio=0, fim=tamanho-1;

		//inicializa o contador de comparacoes
		int nrComparacoes = 1;
		
		//enquanto o meio nao for o inicio e o meio nao for o fim
		while (meio!=inicio && meio!=fim)
		{
				
			//recebe o resultado da comparacao do nome da busca com o nome do meio da lista	
			int comp = nome.compareTo(lista.getItem(meio));
			//out.println("Resultado comp: "+comp);
								
			//se for igual, achou o nome
			//imprime na tela e sai do laco
			if (comp==0)
			{	
				out.println("Achou " + lista.getItem(meio) + "\n" + nome);
				break;
			}
			
			//se for maior o nome esta na outra metade maior
			if (comp>0)
			{
				inicio = meio+1;
				meio = (inicio+fim)/2;
				nrComparacoes++;
			}
			
			//se for menor o nome esta na outra metade menor
			if (comp<0)
			{
				fim = meio-1;
				meio = (inicio + fim)/2;
				nrComparacoes++;					
			}		
		}		
		//imprime na tela o numero de comparacoes realizadas
		out.println("Numero de comparacoes: " + nrComparacoes);	
			
	}

}
