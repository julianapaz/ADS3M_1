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
					removeContato();
					break;

				case 4:
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
	 * 
	 */
	public static void buscaBinaria()
	{
		List lista = new List();
		int indice = 0;
				
		Nodo<String> nodo = agenda.getHead();
		
		while (nodo != null)
		{
			lista.add(nodo.getChave(),indice);
			out.println("Nodo: " + nodo.getChave() + " " + indice);
			indice ++;
			nodo = nodo.getNext();
		}
		
		
		
		int tamanho = lista.countItems();
		out.println(tamanho);
		
		out.println("Digite o nome para busca: ");
		nome = entrada.next();
		int meio = (tamanho-1)/2;
		int inicio=0, fim=tamanho-1;

		int nrComparacoes = 1;
		
		while (meio!=inicio && meio!=fim)
		{
				
				int comp = nome.compareTo(lista.getItem(meio));
				out.println("Resultado comp: "+comp);
								
				if(comp==0)
				{	
					out.println("Achou " + lista.getItem(meio) + "\n" + nome);
					break;
				}
				//nao funciona quando o elemento esta na metade menor e eh maio que o elemento lido
				//alterar codigo
				if(comp>0)
				{
					inicio = meio+1;
					meio = (inicio+fim)/2;
					nrComparacoes++;
				}
			
				if(comp<0)
				{
					fim = meio-1;
					meio = (inicio + fim)/2;
					nrComparacoes++;					
				}
				
					
		}
		
		out.println("Numero de comparacoes: " + nrComparacoes);
		
		/*if( lista.getItem(indiceAtual).contains(nome) )
			out.print(lista.getItem(indiceAtual));
		else
			out.println("Nome nao encontrado!");*/
				
			
	}

}
