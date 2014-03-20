package com.senac.estruturas;

import static java.lang.System.out;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	private Nodo<T> findBefore(Nodo<T> novo) {
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;

		while (atual != null) {
			int comp = atual.compareTo(novo);
			if (comp < 0) {
				anterior = atual;
				atual = atual.getNext();
			}
			if (comp == 0)
				return atual;
			if (comp > 0)
				return anterior;
		}

		return anterior;
	}

	@Override
	public void insert(Nodo<T> novo) {
		Nodo<T> anterior = findBefore(novo);
		if (anterior == null) {
			super.insert(novo);
		} else {
			super.insert(novo, anterior);
		}
	}

	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		insert(novo);
	}

	@Override
	public void append(Nodo<T> novo) {
		insert(novo);
	}

	public void find(T dado) {

		Nodo<?> nodo = getHead();
		do {
			if (dado.equals(nodo.getChave()))
				out.println(nodo);
			nodo = nodo.getNext();
		} while (nodo != null);

	}

	/*
	 * public static void main(String[] args) { ListaOrdenada<String> lista =
	 * new ListaOrdenada<String>();
	 * 
	 * lista.insert(new Nodo<String>("Rafael","51451451")); lista.insert(new
	 * Nodo<String>("Tiago","541542154521"), lista.getHead()); lista.append(new
	 * Nodo<String>("Mauro", null)); lista.insert(new
	 * Nodo<String>("Carlos","51451451")); lista.insert(new
	 * Nodo<String>("Raffael","51451451")); lista.insert(new
	 * Nodo<String>("Rafael","51451451")); lista.insert(new
	 * Nodo<String>("Raphael","51451451"));
	 * 
	 * lista.print(); }
	 */

	public void remove(T chave)
	{
		Nodo<?> nodo = getHead();
		Nodo anterior, prox;
		
		while (!nodo.getNext().getChave().equals(chave))
		
			nodo = nodo.getNext();
		
		anterior = nodo;
		prox = nodo.getNext();
		anterior.setNext(prox.getNext());

	}
	
	
	public Nodo<T> findInicial(char letra){
		Nodo<T> nodo = getHead();
		Nodo<T> anterior=null;
		String nome;
		do {
			nome = (String) nodo.getChave();
			if (letra == nome.charAt(0))
				out.println(nodo);
			
			nodo = nodo.getNext();
		} while (nome.charAt(0) != letra );
		return nodo;
	}

	
	
	public Nodo<T> avanca(Nodo<T> atual)
	{		
		if(atual.getNext().equals(null))
			return atual;
		else
			return atual.getNext();
		
	}
	
	public Nodo<T> retorna(Nodo<T> atual)
	{
	//	Nodo<T> anterior = null;
		Nodo<T> nodo = getHead();
		
			while(!nodo.getNext().equals(null))
			{
			if(atual.equals(nodo.getNext()))
					break;
			else
				nodo = nodo.getNext();
			}
		
	
		return nodo;
	}
	
}
