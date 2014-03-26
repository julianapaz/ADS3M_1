package com.senac.estruturas;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Aplicacao {

	private static ListaOrdenada<String> agenda = new ListaOrdenada<String>();
	private static final char MARCADOR = '*';
	//private static Contato novoContato = new Contato();
	protected static String nome, telefone;
	protected static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) throws Exception 
	{
		FileInputStream arquivo = new FileInputStream("agenda.txt");
		carregaAgenda(new Scanner(arquivo));
		arquivo.close();
		
		int opcao = -1;
		
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
		BufferedWriter agenda = new BufferedWriter(arquivo);

		agenda.write(nome + " " + telefone);
		agenda.newLine();
		agenda.flush();
		agenda.close();
	}
	
	public static void removeContato() throws Exception
	{
		out.println("Digite o nome para excluir");
		nome = entrada.next();
		marcaNomeRemovido(agenda.remove(nome));
	}
	
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
	
	public static void marcaNomeRemovido(Nodo<String> nodo) throws IOException{
		
		BufferedWriter tmp = new BufferedWriter(new FileWriter("tmp.txt"));
		BufferedReader agendaLeitura = new BufferedReader(new FileReader("agenda.txt"));
      
		String linha;
        String contato = nodo.getChave() + " " + nodo.getData();
        
        out.println("Nodo de entrada: "+ nodo);
        
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
                
        //0FileWriter agenda = new FileWriter("agenda.txt");
        
        new File("agenda.txt").delete();
        new File("tmp.txt").renameTo(new File("agenda.txt"));
        
	}
}