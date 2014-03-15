package com.senac.estruturas;

import static java.lang.System.out;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;



public class Principal {

	private static ListaOrdenada<String> agenda = new ListaOrdenada<String>();
	private static Contato novoContato = new Contato();

	public static void main(String[] args) throws Exception {
		int opcao = 1;
		Scanner entrada = new Scanner(System.in);
		

		carregaAgenda(new Scanner( new FileInputStream("agenda.txt") ));
	
		out.println("CONTATOS DA AGENDA \n");
		agenda.print();
		out.println("\n");
	    insereNovoContato();
	    agenda.print();
		//agenda.print();
		/*while (opcao != 0) {
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
		*/
	/*	File arquivo = new File("agenda.txt"); //se já existir, será sobreescrito  
		FileWriter fw = new FileWriter(arquivo);  
		BufferedWriter bw = new BufferedWriter(fw);  
		
		String contatos = agenda.toString();
		
		bw.write(contatos);  
		bw.flush();  
		bw.close();*/
		
		
		//System.exit(0);
	}
	
	private static void insereNovoContato() throws IOException {
		// TODO Auto-generated method stub
		Contato cont = new Contato("beatriz","518415985");
		agenda.insert(new Nodo<>(cont.getNome(), cont.getTelefone()));
		
		
			  //close();
		
		
		FileWriter arquivo = new FileWriter("agenda.txt",true);
		 
		BufferedWriter bw = new BufferedWriter(arquivo);  
		
				
		bw.write(cont.toString());  
		bw.flush();  
		bw.close();
		
		
		
		
	    /*PrintWriter gravarArq = new PrintWriter(arq);
		

	    gravarArq.write("\nnome bia telefone 51841595727");*/
	  

	   // arquivo.close();



		
		
		        /*BufferedWriter out = new BufferedWriter(new FileWriter("agenda.txt"));
		        out.flush();  
		        out.write("Nome bia telefone 518415982");
		        out.close();
		  */



	}

	private static void carregaAgenda(Scanner arquivo)  {
	
		boolean podeGravar = false;
		String nome = null;
		String telefone = null;
		
		while (arquivo.hasNext()) {
						
			String cmd = arquivo.next().toLowerCase();
			if(cmd.equals("nome")){
					nome = arquivo.next();
					/*novoContato.setNome(arquivo.next());
					out.print(novoContato.getNome());*/
			}
			
			if(cmd.equals("telefone")){
					telefone = arquivo.next();
					/*novoContato.setTelefone(arquivo.next());*/
					/*out.print(novoContato.getTelefone());*/
					podeGravar = true;
					
			}
			
			if (podeGravar)
			{
				agenda.insert(new Nodo<>(nome, telefone ));
				out.println("pode gravar");
				podeGravar = false;
				
			}
			
			
		}
		//throw new Exception("Arquivo de descricao do labirinto invalido.");
		
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
		
		File arquivo = new File("agenda.txt"); //se já existir, será sobreescrito  
		FileWriter fw = new FileWriter(arquivo);  
		BufferedWriter bw = new BufferedWriter(fw);  
		
		String contatos = agenda.toString();
		
		bw.write(contatos);  
		bw.flush();  
		bw.close();

	}
}
