package com.senac.mvc.controller;

import com.senac.mvc.model.Pessoa;
import com.senac.mvc.view.ContatoView;

public class PessoaController {

	private Pessoa contato;
	
	public void criarContato()
	{
		contato = new Pessoa();
		contato.setNome("Rafael");
		contato.setTelefone("555-1234");
	}
	
	public void exibirContato( ContatoView view )
	{
		view.printContato(contato.getNome(), contato.getTelefone());
	}
	
}
