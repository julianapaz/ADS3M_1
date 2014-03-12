package com.senac.estruturas;

public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> {

	private T chave;
	private Nodo<T> next;
	private T dado;
	
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
	
	
 	private void setData(T dado)
 
	{
		this.dado = dado;
	}
 	
 	private T getChave(){
 		return chave;
 	}
 	
 	private void setChave(){
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
		String res = "Nome: " + getChave() + "\nTelefone: "
				+ getData();
		
		return res;
	}

}
