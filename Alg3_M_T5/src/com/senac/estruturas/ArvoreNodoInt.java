package com.senac.estruturas;

public class ArvoreNodoInt {
	private NodoInt raiz;
	
	
	
	ArvoreNodoInt()
	{
		
	}
	
	ArvoreNodoInt(int v)
	{
		raiz = new NodoInt(v);
	}
	
	private NodoInt getRaiz()
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
	
	private NodoInt insere(NodoInt r, int v)
	{
		if(r==null)
			r= new NodoInt(v);
		
		else
		{
			if(v > r.getValor())
			{
				if( r.getEsquerda() == null )
					r.setEsquerda(new NodoInt(v));
				else
					r.setEsquerda(insere(r.getEsquerda(), v));
			}
			else
			{
				if( r.getDireita() == null )
					r.setDireita(new NodoInt(v));
				else
					r.setDireita(insere(r.getDireita(), v));
			}
		}
		
		return r;
	}
	
	
	private void print()
	{
		NodoInt nodo = raiz;
		
		while( nodo != null )
		{
			nodo.print(nodo.getEsquerda());
			System.out.println(nodo);
			nodo.print(nodo.getDireita());
		}
	}
}
