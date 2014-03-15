package com.senac.mvc.view;

import static java.lang.System.out;

public class ExtendedView extends ContatoView {

	public void printContato(String nome, String telefone)
	{
		out.println("Nome: " + nome);
		out.println("Telefone: " + telefone);
	}
	
}
