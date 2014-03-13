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

}
