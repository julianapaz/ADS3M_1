package com.senac.estruturas;

public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> {

	private T chave;
	private T dado;
	private Nodo<T> next;
	
	public Nodo()
	{
		this.chave = null;
		this.dado = null; 
		this.next = null;
	}
	
	public Nodo(T chave, T dado)
	{
		this.chave = chave;
		this.dado = dado;
		this.next = null;
	}
	
	public T getData()
	{
		return dado;
	}
	
	
 	public void setData(T dado)
 
	{
		this.dado = dado;
	}
 	
 	public T getChave(){
 		return chave;
 	}
 	
 	public void setChave(){
 		this.chave = chave;
 	}

	
	public Nodo<T> getNext()
	{
		return next;
	}
	
	public void setNext(Nodo<T> next)
	{
		this.next = next;
	}

	@Override
	public int compareTo(Nodo<T> nodo) {
		return chave.compareTo(nodo.getChave());
	}
	
	public String toString(){
		String res = getChave() + " "
				+ getData();
		
		return res;
	}

}
