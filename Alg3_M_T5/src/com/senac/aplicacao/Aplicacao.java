package com.senac.aplicacao;

import com.senac.estruturas.Contato;
import com.senac.estruturas.Nodo;
import com.senac.estruturas.NodoInt;

public class Aplicacao{
	
	public static void main(String[] args) 
	{
		NodoInt raiz = new NodoInt(20);
		
		raiz.insere(raiz, 22);
		raiz.insere(raiz, 50);
		/*raiz.insere(raiz,15);
		raiz.insere(raiz,8);
		raiz.insere(raiz,17);
		raiz.insere(raiz,7);
		raiz.insere(raiz,3);
		raiz.insere(raiz,11);
		raiz.insere(raiz,9);
		raiz.insere(raiz,15);*/
		
		raiz.print(raiz);
	}
	

}
