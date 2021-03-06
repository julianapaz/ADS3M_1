package com.senac.aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.senac.estruturas.ArvoreBinaria;
import com.senac.estruturas.Contato;
import com.senac.estruturas.Nodo;

public class Aplicacao{
	
	private static ArvoreBinaria<String> agenda = new ArvoreBinaria<String>();
	private static final char MARCADOR = '*';
	private static Contato<String> novoContato = new Contato<String>();
	private static Scanner entrada = new Scanner(System.in);

	
	public static void main(String[] args) throws Exception 
	{		
		 FileInputStream arquivo = new FileInputStream("agenda.txt");
		//Chamada do metodo que carrega o arquivo na memoria
		carregaAgenda(new Scanner(arquivo));
		arquivo.close();
		
		int opcao = -1;
		
		//Exibe menu
		while (opcao != 0)
		{
			System.out.print("AGENDA \nDigite sua opcao \n" + "1-Adicionar contato\n"
					+ "2-Buscar pelo nome\n" + "3-Remover contato\n" + "4-Exibir elementos\n"
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
					OpcoesDeExibicaoDeElementos();
					break;

				default:

					break;
			}

		}
		
	}
	
	/**
	 * Metodo que insere um novo contato na agenda
	 * @throws IOException
	 */

	private static void cadatraNovoContato() throws IOException {
		// TODO Auto-generated method stub
		Contato<String> novo = new Contato<String>();
		System.out.println("Digite o nome");
		novo.setNome(entrada.next());
		System.out.println("Digite o telefone: ");
		novo.setTelefone(entrada.next());
		
		agenda.insere( agenda.getRaiz(), new Nodo<String>( novo.getNome(), novo.getTelefone()));
		insereNoArquivo(novo);
		System.out.println("Altura: "  + agenda.altura(agenda.getRaiz()));
		System.out.println("Total de contatos: "+agenda.getTotalNodos());
	}
	/**
	 * Metodo que escreve o novo contato no arquivo
	 * @param novo
	 * @throws IOException
	 */

	public static void insereNoArquivo(Contato<String> novo) throws IOException
	{
		FileWriter arquivo = new FileWriter("agenda.txt", true);
		BufferedWriter agenda = new BufferedWriter(arquivo);

		agenda.write(novo.getNome() + " " + novo.getTelefone());
		agenda.newLine();
		agenda.flush();
		agenda.close();
	}
	

	/**
	 * Metodo que busca um nome na agenda
	 */
	private static void buscaContato()
	{
		String nome;
		System.out.println("Digite o nome para busca: ");
		nome = entrada.next();
		agenda.busca(agenda.getRaiz(), nome, 0);	
	}
	
	/**
	 * Metodo que remove um contato da agenda
	 * @throws IOException
	 */
	private static void removeContato() throws IOException 
	{
		String nome;
		System.out.println("Digite o nome para remover");
		nome = entrada.next();
		Nodo<String> contatoRemovido = agenda.remove(agenda.getRaiz(), nome);
		if( contatoRemovido != null )
			marcaNomeRemovido(contatoRemovido);
	}
	
	/**
	 * Metodo que insere um marcado no nome removido 
	 * @param nodo
	 * @throws IOException
	 */
	public static void marcaNomeRemovido(Nodo<String> nodo) throws IOException
	{
	
		BufferedWriter tmp = new BufferedWriter(new FileWriter("tmp.txt"));
		BufferedReader agendaLeitura = new BufferedReader(new FileReader("agenda.txt"));
  
		String linha;
		String contato = nodo.getChave() + " " + nodo.getDado();
   
		while ((linha = agendaLeitura.readLine()) != null)
		{

			if (linha.contains(contato))
				linha = MARCADOR + contato;
			tmp.write(linha);
			tmp.newLine();
		}
   	
		tmp.flush();
		tmp.close();
		agendaLeitura.close();
            
		new File("agenda.txt").delete();
		new File("tmp.txt").renameTo(new File("agenda.txt"));
		}

		private static void OpcoesDeExibicaoDeElementos() 
		{
			int op = -1;
			while( op!= 0 )
			{
				//System.out.println(agenda.getTotalNodos());
				//System.out.println(agenda.getAltura(agenda.getRaiz()));
				System.out.println("1-Travessia Prefixa\n2-Travessia Infixa\n3-Travessia Posfixa" +
		 		"\n4-Busca em Largura\n5-Busca em Profundidade\n0-VOLTAR");
				op = entrada.nextInt();
		 
				if ( op == 1 )
					agenda.travessiaPrefixa(agenda.getRaiz());
				else if ( op == 2 )
					agenda.travessiaInfixa(agenda.getRaiz());
				else if ( op == 3 )
				 agenda.travessiaPosFixa(agenda.getRaiz());
				else
					System.out.println("OPCAO INVALIDA");
		 /******************
		  * FAZER O RESTANTE
		  */
			}
		}
		
		/**
		 * Metodo que le contato do arquivo
		 * Testa se eh um contato valido
		 * Insere na arvore
		 */
		private static void carregaAgenda(Scanner arquivo)
		{
			char nomeTeste;
		
			while (arquivo.hasNext()) 
			{	
				novoContato.setNome(arquivo.next());
				nomeTeste = novoContato.getNome().charAt(0);
				if(nomeTeste == MARCADOR)
					arquivo.next();
				else
				{
					novoContato.setTelefone(arquivo.next());
					agenda.insere(agenda.getRaiz(),new Nodo<>(novoContato.getNome(), novoContato.getTelefone()));
				}
			}
			arquivo.close();
		}
			
	}
	

