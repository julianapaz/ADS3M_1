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

	public static void main(String[] args) throws IOException {
		int opcao = 1;
		Scanner entrada = new Scanner(System.in);

		carregaAgenda(new Scanner(new FileInputStream("agenda.txt")));

		while (opcao != 0) {
			out.print("AGENDA \nDigite sua opcao \n" 
					+ "1-Cadastrar\n"
					+ "2-Buscar\n"
					+ "4-Exibir lista\n"
					+ "0-Sair\n");
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
				//removeContato();
				break;

			case 4:
				agenda.print();

			default:
				
				break;
			}

		}
	}

	private static void carregaAgenda(Scanner arquivo) {

		boolean podeGravar = false;
		String nome = null;
		String telefone = null;
		//int index = 0;

		while (arquivo.hasNext()) {

			String cmd = arquivo.next().toLowerCase();
			if (cmd.equals("nome")) {
				nome = arquivo.next();
				/*
				 * novoContato.setNome(arquivo.next());
				 * out.print(novoContato.getNome());
				 */
			}

			if (cmd.equals("telefone")) {
				telefone = arquivo.next();
				/* novoContato.setTelefone(arquivo.next()); */
				/* out.print(novoContato.getTelefone()); */
				podeGravar = true;

			}

			if (podeGravar) {
				Contato novoContato = new Contato(nome, telefone);
				//index++;
				//agenda.insert(new Nodo<>(index,novoContato));
				agenda.insert(new Nodo<>(nome, telefone));
				//out.println("pode gravar");
				podeGravar = false;
			}
		}
	}

	private static void buscaContato() {
		Scanner entrada = new Scanner(System.in);
		//String nome;
		String inicial = null;

		//out.println("Digite o nome para pesquisar:");
		//nome = entrada.next();
		out.println("Digite a letra inicial:");
		inicial = entrada.nextLine();
		
		//agenda.find(nome);
		agenda.findInicial(inicial.charAt(0));
	}

	private static void cadatraNovoContato() throws IOException {
		// utilzando assim somente para teste, ainda sem entrada do teclado
		
		Scanner entrada = new Scanner(System.in);
		
		Contato  novoContato= new Contato("beatriz", "518415985");
		
		out.println("Digite o nome:");
		novoContato.setNome(entrada.nextLine());
		
		out.println("Digite o telefone:");
		novoContato.setTelefone(entrada.next());
		
		agenda.insert(new Nodo<>(novoContato.getNome(), novoContato.getTelefone()));

		FileWriter arquivo = new FileWriter("agenda.txt", true);

		BufferedWriter bw = new BufferedWriter(arquivo);
		//out.print(novoContato);
		//n funciona com tail, pega o ultimo salvo na agenda.txt
		//bw.write(agenda.getTail().toString());
		bw.write(novoContato.toString());
		bw.flush();
		bw.close();

	}
	
	/*private static void removeContato(){
		Scanner entrada = new Scanner(System.in);
		out.println("Digite o nome para excluir: ");
		
		
		
	}*/
}
