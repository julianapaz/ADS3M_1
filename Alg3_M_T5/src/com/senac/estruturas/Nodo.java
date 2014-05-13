package com.senac.estruturas;

public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> 
{

	private T dado;
	private T chave;
	private Nodo<T> esquerda;
	private Nodo<T> direita;
	
	public Nodo()
	{
		dado = null;
		chave = null;
		esquerda = null;
		direita = null;
				
	}
	
	public Nodo(T chave, T dado)
	{
		this.dado = dado;
		this.chave = chave;
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
	
	public T getChave()
	{
		return chave;
	}
	
	public void setChave(T chave)
	{
		this.chave = chave;
	}
	
	public Nodo<T> getDireita()
	{
		return direita;
	}
	
	public void setDireita(Nodo<T> direita)
	{
		this.direita = direita;
	}
 	
	public Nodo<T> getEsquerda()
	{
		return esquerda;
	}
	
	public void setEsquerda(Nodo<T> esquerda)
	{
		this.esquerda = esquerda;
	}
//ver com prof - generics
	public int compareTo(Nodo<T> r) {
		return chave.compareTo(r.getChave());
	}
	
	
	public String toString(){
		String str = getChave() + " " + getDado();
		
		return str;
	}
	
	public int compareTo(T str)
	{
		return chave.compareTo(str);
	}

}
