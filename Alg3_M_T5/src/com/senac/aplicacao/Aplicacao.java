package com.senac.aplicacao;

import com.senac.estruturas.ArvoreNodoInt;
import com.senac.estruturas.Contato;
import com.senac.estruturas.Nodo;
import com.senac.estruturas.NodoInt;

public class Aplicacao{
	
	public static void main(String[] args) 
	{
		NodoInt raiz = new NodoInt(5);
		ArvoreNodoInt arvore = new ArvoreNodoInt(raiz);
		
		arvore.insere(arvore.getRaiz(), 7);
		arvore.insere(arvore.getRaiz(), 2);
		arvore.insere(arvore.getRaiz(), 3);
		arvore.insere(arvore.getRaiz(), 8);
		arvore.insere(arvore.getRaiz(), 0);
		arvore.insere(arvore.getRaiz(), 0);
		
		System.out.println("Travessia Infixa: ");
		arvore.printInfixa(arvore.getRaiz());
		System.out.println("Travessia Prefixa");
		arvore.printPrefixa(arvore.getRaiz());
		
		
		
	}
	

}
