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
/** Metodo que percorre a lista comparando a chave 
 * 	Realiza teste se a chave esta no head ou 
 * 	@param chave
 *  @return o nodo que possuia a chave, o nodo removido
 */
	public Nodo<T> remove(T chave) {
	
		Nodo<T> nodo = getHead();
		Nodo<T> anterior=null, prox=null;
		Nodo<T> nodoRemovido=null;

		//se o nodo a ser movido for o primeiro
		if (chave.equals(getHead().getChave()))
		{
			nodoRemovido = getHead();
			//o head recebe o proximo nodo
			setHead(getHead().getNext());
			
		}
		else
		{
			//enquanto a chave do proximo do nodo atual nao for a chave de procura
			while (!nodo.getNext().getChave().equals(chave))
				//nodo atual recebe o proximo
				nodo = nodo.getNext();
			
			//se o nodo foi encontrado
			if (nodo != null)
			{
				anterior = nodo;
				prox = nodo.getNext();
				nodoRemovido = prox;
				anterior.setNext(prox.getNext());
			}			
		}
		return nodoRemovido;
	}

	/** Metodo que retorna o primeiro nodo encontrado que possue a letra inicial igual a da chave
	 * @param letra
	 * @return
	 */
	public Nodo<T> findInicial(char letra)
	{
		Nodo<T> nodo = getHead();
		String nome;
		
		do {
				nome = (String) nodo.getChave();
				if (letra == nome.charAt(0)) {
					break;
			}
			nodo = nodo.getNext();
		} while (nodo != null);
		
		return nodo;
	}

	/** Metodo que avanca para o proximo nodo
	 * 
	 * @param atual
	 * @return
	 */
	public Nodo<T> avanca(Nodo<T> atual) {
		// se o nodo atual é o fim, retorna ele mesmo
		if (atual.equals(getTail()))
			return getHead();
		
		else
			return atual.getNext();
	}
/**	Metodo que percorre a lista utilizando getNext() para realizar a comparacao 
 * 	sem perder o atual para retornar como o anterior   
 *	@param atual
 * 	@return nodo - o nodo anterior do atual
 */
	public Nodo<T> retorna(Nodo<T> atual) {
		Nodo<T> nodo = getHead();
		
		//se o nodo atual eh o head avanca para o final
		if (atual.equals(getHead()))
			nodo = getTail();
		
		else
		{
			//enquanto nao for o ultimo
			while (nodo.getNext() != null) //uso equals ou !=
			{
				//se o atual eh o proximo
				if (atual.equals(nodo.getNext()))
					break;
				else
					nodo = nodo.getNext();
			}
		}
		
		return nodo;
	}

}
