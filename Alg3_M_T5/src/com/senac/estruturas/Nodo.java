package com.senac.estruturas;

public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> {

	private T chave;
	private T dado;
	private Nodo<T> esquerda;
	private Nodo<T> direita;
	
	public Nodo()
	{
		this.chave = null;
		this.dado = null; 
		this.esquerda = null;
		this.direita = null;
	}
	
	public Nodo(T chave, T dado)
	{
		this.chave = chave;
		this.dado = dado;
		this.esquerda = null;
		this.direita = null;
	}
	
	public T getDado()
	{
		return dado;
	}
	
	
 	public void setDado(T dado)
 
	{
		this.dado = dado;
	}
 	
 	public T getChave(){
 		return chave;
 	}
 	
 	public void setChave(T chave){
 		this.chave = chave;
 	}

 	
 	public Nodo<T> getDireita()
	{
		return direita;
	}
	
	public void setDireita(Nodo<T> next)
	{
		this.direita = next;
	}
 	
 	
	
	public Nodo<T> getEsquerda()
	{
		return esquerda;
	}
	
	public void setEsquerda(Nodo<T> next)
	{
		this.esquerda = next;
	}

	@Override
	public int compareTo(Nodo<T> nodo) {
		return chave.compareTo(nodo.getChave());
	}
	
	public String toString(){
		String res = getChave() + " "
				+ getDado();
		
		return res;
	}

}
