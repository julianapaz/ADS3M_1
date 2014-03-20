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

	protected static String nome, telefone;
	protected static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int opcao = 1;
		Scanner entrada = new Scanner(System.in);

		carregaAgenda(new Scanner(new FileInputStream("agenda.txt")));

		while (opcao != 0) {
			out.print("AGENDA \nDigite sua opcao \n" + "1-Cadastrar\n"
					+ "2-Buscar\n" + "3-Remover\n" + "4-Exibir lista\n"
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
				removeContato();
				break;

			case 4:
				agenda.print();

			default:

				break;
			}

		}
	}

	private static void carregaAgenda(Scanner arquivo) {

		while (arquivo.hasNext()) {
			nome = arquivo.next().toLowerCase();

			telefone = arquivo.next().toLowerCase();

			agenda.insert(new Nodo<>(nome, telefone));
		}
	}

	private static void buscaContato() {
		Scanner entrada = new Scanner(System.in);

		String inicial = null;

		out.println("Digite a letra inicial:");
		inicial = entrada.nextLine();

		// COLOCAR PARA EXIBIR O PRIMEIRO NOME ENCONTRADO NA LISTA
		Nodo nomeAtual = agenda.findInicial(inicial.charAt(0));
		Nodo ultimoNome;
		int op = -1;

		while (op != 0) {
			out.println("1 - Avanca\n2 - Retornar");
			op = entrada.nextInt();

			if (op == 1) {
				nomeAtual = agenda.avanca(nomeAtual);
				out.println(nomeAtual);
							}

			else if (op == 2) {
				nomeAtual = agenda.retorna(nomeAtual);
				out.println(nomeAtual);
			}

			else
				out.println("Opcao invalida!");
		}
	}

	private static void cadatraNovoContato() throws IOException {
		// utilzando assim somente para teste, ainda sem entrada do teclado

		out.println("Digite o nome:");
		nome = entrada.nextLine();

		out.println("Digite o telefone:");
		telefone = entrada.next();

		agenda.insert(new Nodo<>(nome, telefone));

		FileWriter arquivo = new FileWriter("agenda.txt", true);

		BufferedWriter bw = new BufferedWriter(arquivo);

		bw.write(nome + " " + telefone);
		bw.flush();
		bw.close();
	}

	public static void removeContato() {
		out.println("Digite o nome para excluir");
		nome = entrada.next();
		agenda.remove(nome);
	}
}
