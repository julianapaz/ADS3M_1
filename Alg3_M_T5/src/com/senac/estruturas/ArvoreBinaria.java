package com.senac.estruturas;

public class ArvoreBinaria<T extends Comparable<T>> 
{
	
	private Nodo raiz;
	
	
	public ArvoreBinaria(Nodo raiz)
	{
		this.raiz = raiz;

	}
	
	public ArvoreBinaria()
	{
		
	}
	
	public Nodo getRaiz()
	{
		return raiz;
	}
	
	public Nodo insere(Nodo r, Nodo novo)
	{
		if( r==null )
			r = novo;
		else
		{
			int cmp = novo.compareTo(r);
			//System.out.println(cmp);
			
			if( cmp < 0 ) 
			{
				if( r.getEsquerda() == null )
					r.setEsquerda(novo);
				else
					r.setEsquerda(insere(r.getEsquerda(),novo));
			}
			else if( cmp > 0 )
			{
				if( r.getDireita() == null )
					r.setDireita(novo);
				else
					r.setDireita(insere(r.getDireita(),novo));
			}
			else
				System.out.println("Nodo ja existe na arvore");
				
		}
		
		
		return r;
	}


public int compareTo(Nodo o) {
		return raiz.compareTo(o);
	}
	
	//arrumar
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
	
	
	
	/**
	 * Metodo que busca um contato pela chave
	 * @param nodo
	 * @param dado
	 * @return
	 */
	
	public Nodo busca(Nodo nodo, String dado)
	{
		
		if ( nodo == null)
			System.out.println("Dado nao existe na arvore");
		else
		{
			//System.out.println("Nodo atual: " + nodo);
			//System.out.println("Chave: " + nodo.getChave());
			int cmp = dado.compareTo(nodo.getChave());
			System.out.println("CMp: "+cmp);
			
			if( cmp == 0 )
				System.out.println(nodo);
			
			else if( cmp < 0 )
				busca(nodo.getEsquerda(), dado);
			else
				busca(nodo.getDireita(),dado);
					
		}
		return nodo;
	}

	
	public static void main(String[] args) {
		
		ArvoreBinaria<String> arvore = new ArvoreBinaria<>(new Nodo("j","716276336"));
		
		arvore.insere(arvore.getRaiz(), new Nodo("d","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo("b","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo("c","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo("d","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo("e","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo("f","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo("g","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo("a","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo("p","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo("r","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo("k","282737347"));
		
		System.out.println("Travessia Infixa");
		arvore.printInfixa(arvore.getRaiz());
		System.out.println("\nTravessia Prefixa");
		System.out.println();
	}
	
}
