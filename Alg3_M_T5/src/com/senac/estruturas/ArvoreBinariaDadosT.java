package com.senac.estruturas;

public class ArvoreBinariaDadosT<T extends Comparable<T>> implements Comparable<Nodo<T>> 
{
	
	private Nodo<?> raiz;
	
	
	public ArvoreBinariaDadosT(Nodo<?> raiz)
	{
		this.raiz = raiz;

	}
	
	public ArvoreBinariaDadosT()
	{
		
	}
	
	public Nodo<?> getRaiz()
	{
		return raiz;
	}
	
	public Nodo<?> insere(Nodo<?> r, Nodo<?> novo)
	{
		if( r==null )
			r = novo;
		else
		{
			int cmp = novo.compareToT(r);
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



	@Override
	public int compareTo(Nodo<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//arrumar
	public void printInfixa(Nodo nodo)
	{
		if( nodo!=null )
		{
			printInfixa(nodo.getEsquerda());
			System.out.println(nodo.stringToString());
			printInfixa(nodo.getDireita());
			
		}
			
	}
	
	public void printPrefixa(Nodo nodo)
	{
		if( nodo!=null )
		{
			System.out.println(nodo.stringToString());
			printInfixa(nodo.getEsquerda());
			printInfixa(nodo.getDireita());
		}
	}
	
	public static void main(String[] args) {
		
		ArvoreBinariaDadosT<?> arvores = new ArvoreBinariaDadosT<>(new Nodo<String>("Juliana","716276336"));
		
		arvores.insere(arvores.getRaiz(), new Nodo<String>("Adiana","282737347"));
		arvores.insere(arvores.getRaiz(), new Nodo<String>("Kaio","282737347"));
		arvores.insere(arvores.getRaiz(), new Nodo<String>("Breno","282737347"));
		
		System.out.println("Travessia Infixa");
		arvores.printInfixa(arvores.getRaiz());
		System.out.println("\nTravessia Prefixa");
		arvores.printPrefixa(arvores.getRaiz());
	}
	
}
