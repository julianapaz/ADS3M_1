package com.senac.estruturas;

import static java.lang.System.out;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	private static ListaOrdenada<String> agenda = new ListaOrdenada<String>();

	//private static Contato novoContato = new Contato();
	protected static String nome, telefone;
	protected static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int opcao = 1;

		carregaAgenda(new Scanner(new FileInputStream("agenda.txt")));
		
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

	private static void carregaAgenda(Scanner arquivo) {

		while (arquivo.hasNext()) 
		{	
			nome = arquivo.next();
			//novoContato.setNome(nome = arquivo.next());
			telefone = arquivo.next();
			//novoContato.setTelefone(telefone = arquivo.next());
			//agenda.insert(new Nodo<>(novoContato.getNome(), novoContato.getTelefone()));
			agenda.insert(new Nodo<>(nome, telefone));
		}
	}

	private static void buscaContato() 
	{
		String letra = null;

		out.println("Digite a letra inicial:");
		letra = entrada.next();

		//EXIBE O PRIMEIRO NOME ENCONTRADO NA LISTA
		out.println(agenda.findInicial(letra.charAt(0)));	
		navega(agenda.findInicial(letra.charAt(0)));
	}
	
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

	private static void cadatraNovoContato() throws IOException 
	{
		out.println("Digite o nome:");
		nome = entrada.next();

		out.println("Digite o telefone:");
		telefone = entrada.next();

		agenda.insert(new Nodo<>(nome, telefone));
		
		insereNoArquivo(nome, telefone);

	}
	
	public static void insereNoArquivo(String nome, String telefone) throws IOException
	{
		FileWriter arquivo = new FileWriter("agenda.txt", true);

		BufferedWriter bw = new BufferedWriter(arquivo);

		bw.write(nome + " " + telefone);
		bw.newLine();
		bw.flush();
		bw.close();
	}
	
	public static void removeContato() throws Exception
	{
		out.println("Digite o nome para excluir");
		nome = entrada.next();
		agenda.remove(nome);	
		atualizaArquivo();
	}
	

	
	public static void atualizaArquivo() throws IOException
	{
		new File("agenda.txt");
		FileWriter arquivo = new FileWriter("agenda.txt");

		BufferedWriter bw = new BufferedWriter(arquivo);
		Nodo<String> nodo = agenda.getHead();
		
		while(nodo != null)
		{
			String contato = (String)nodo.getChave() + " " + (String)nodo.getData();
			bw.write(contato);
			bw.newLine();
			nodo = nodo.getNext();
		}
		bw.flush();
		bw.close();
		
	}
}
