package com.senac.estruturas;

public class ArvoreBinaria<T extends Comparable<T>> 
{
	
	private Nodo raiz;
	private int totalNodos;

	
	
	public ArvoreBinaria(Nodo raiz)
	{
		this.raiz = raiz;
		this.totalNodos = 1;
		

	}
	
	public ArvoreBinaria()
	{
		raiz = null;
		totalNodos = 0;
	}
	
	public Nodo getRaiz()
	{
		return raiz;
	}
	
	public int getTotalNodos()
	{
		return totalNodos;
	}
	
	/**
	 * Metodo que insere um nodo nodo a partir da raiz
	 * @param r
	 * @param novo
	 * @return nodo inserido
	 */
	
	public Nodo insere(Nodo r, Nodo novo)
	{
		
		if( r==null )
			r = novo;
		else
		{
			int cmp = novo.compareTo(r);
		
			if( cmp < 0 ) 
			{
				if( r.getEsquerda() == null )
				{
					r.setEsquerda(novo);
					totalNodos++;
				}
		
				else
					r.setEsquerda(insere(r.getEsquerda(),novo));
			}
			else if( cmp > 0 )
			{
				if( r.getDireita() == null )
				{
					r.setDireita(novo);
					totalNodos++;
				}
				else
					r.setDireita(insere(r.getDireita(),novo));
			}
			else
				System.out.println("Nodo ja existe na arvore");	
		}
		
		
		return r;
	}

	/*
	 * Nao sei usar compare
	 */
	public int compareTo(Nodo o) {
		return raiz.compareTo(o);
	}
	
	
	public void printInfixa(Nodo nodo)
	{
		if( nodo != null )
		{
			printInfixa(nodo.getEsquerda());
			System.out.println(nodo);
			printInfixa(nodo.getDireita());
			
		}
			
	}
	
	public void printPrefixa(Nodo nodo)
	{
		if( nodo != null )
		{
			System.out.println(nodo);
			printInfixa(nodo.getEsquerda());
			printInfixa(nodo.getDireita());
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		ArvoreBinaria<String> arvore = new ArvoreBinaria<>(new Nodo("j","716276336"));

		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("b","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("c","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("d","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("e","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("f","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("g","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("a","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("p","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("r","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("k","282737347"));
		System.out.println(arvore.getTotalNodos());

	}
	
}
