package com.senac.estruturas;

public class ArvoreNodoInt {
	private NodoInt raiz;
	
	
	
	ArvoreNodoInt()
	{
		
	}
	
	public ArvoreNodoInt(int v)
	{
		raiz = new NodoInt(v);
	}
	
	public ArvoreNodoInt(NodoInt r)
	{
		raiz = r;
	}
	
	public NodoInt getRaiz()
	{
		return raiz;
	}
	
	/**
	 * Metodo de insercao, recebe a raiz, verifica se o dados 
	 * eh maior ou menor, insere no respectivo lado ate encontrar uma posicao vazia
	 * @param raiz
	 * @param valor
	 * @return raiz
	 */
	
	public NodoInt insere(NodoInt r, int v)
	{
		if(r==null)
			r= new NodoInt(v);
		
		else
		{
			if(v < r.getValor())
			{
				if( r.getEsquerda() == null )
					r.setEsquerda(new NodoInt(v));
				else
					r.setEsquerda(insere(r.getEsquerda(), v));
			}
			else if( v > r.getValor() )
			{
				if( r.getDireita() == null )
					r.setDireita(new NodoInt(v));
				else
					r.setDireita(insere(r.getDireita(), v));
			}
			else
				System.out.println("Nodo já existe na arvore");
		}
		
		return r;
	}
	
	/**
	 * Metodo que imprime os nodos da arvore do forma prefixa
	 * avalia o nodo da raiz
	 * avalia o filho da esquerda
	 * avalia o filho da direita
	 * @param no
	 */
	
	public void printPrefixa(NodoInt no)
	{	
		if(no != null)
		{
			System.out.println(no.getValor());
			printInfixa(no.getEsquerda());
			printPrefixa(no.getDireita());	
			
		}
	}
	
	/**
	 * Metodo que imprime os nodos da arvore do forma infixa
	 * Imprime os dados de forma ordenada
	 * avalia o filho da esquerda
	 * avalia o nodo da raiz 
	 * avalia o filho da direita
	 * @param no
	 */

	public void printInfixa(NodoInt no)
	{
		if(no != null)
		{
			printInfixa(no.getEsquerda());
			System.out.println(no.getValor());
			printInfixa(no.getDireita());	
			
		}
	}
}
