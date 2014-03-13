package com.senac.estruturas;

import static java.lang.System.out;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	private static ListaEncadeada<String> agenda = new ListaEncadeada<String>();

	public static void main(String[] args) throws IOException {
		int opcao = 1;
		Scanner entrada = new Scanner(System.in);

		while (opcao != 0) {
			out.print("AGENDA \nDigite sua opcao \n" + "1-Cadastrar\n"
					+ "2-Buscar\n" + "3-Exibe lista\n" + "0-Sair\n");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				// cadastra novo contato
				cadatraNovoContato();

				break;

			case 2:
				// busca contato
				buscaContato();

				break;

			case 3:
				agenda.print();

				
			default:
				break;
			}

		}
		
	/*	File arquivo = new File("agenda.txt"); //se j� existir, ser� sobreescrito  
		FileWriter fw = new FileWriter(arquivo);  
		BufferedWriter bw = new BufferedWriter(fw);  
		
		String contatos = agenda.toString();
		
		bw.write(contatos);  
		bw.flush();  
		bw.close();*/
		
		
		System.exit(0);
	}
	
	private static void buscaContato() {
		Scanner entrada = new Scanner(System.in);
		String nome;

		out.println("Digite o nome para pesquisar:\n");
		nome = entrada.next();

		out.print(agenda.find(nome));

	}

	private static void cadatraNovoContato() throws IOException {

		Scanner entrada = new Scanner(System.in);
		Nodo novoContato;
		String nome, telefone;

		out.print("Digite o nome:");
		nome = entrada.next();
		out.print("Digite o telefone:");
		telefone = entrada.next();

		novoContato = new Nodo<>(nome, telefone);
		agenda.insert(novoContato);

		// insere no final do arquivo
		
		File arquivo = new File("agenda.txt"); //se j� existir, ser� sobreescrito  
		FileWriter fw = new FileWriter(arquivo);  
		BufferedWriter bw = new BufferedWriter(fw);  
		
		String contatos = agenda.toString();
		
		bw.write(contatos);  
		bw.flush();  
		bw.close();

	}
}
