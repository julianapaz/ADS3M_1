package com.senac.mvc.app;

import com.senac.mvc.controller.PessoaController;
import com.senac.mvc.view.CompactView;
import com.senac.mvc.view.ExtendedView;

public class AgendaTelefonica {

	public static void main(String[] args) {
		PessoaController controller = new PessoaController();
		controller.criarContato();
		
		controller.exibirContato(new ExtendedView());
		controller.exibirContato(new CompactView());
	}

}
