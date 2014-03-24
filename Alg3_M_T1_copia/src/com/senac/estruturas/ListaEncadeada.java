package com.senac.estruturas;

import static java.lang.System.out;

public class ListaEncadeada<T extends Comparable<T>> {
	
	private Nodo<T> head; // will be a Nodo
	private Nodo<T> tail; // will be a Nodo
	
	public Nodo<T> getHead()
	{
		return head;
	}
	
	public Nodo<T> getTail() {
		return tail;
	}
	
	protected void setHead(Nodo<T> novo){
		head = novo;
	}
	
	public void print()
	{
		Nodo<T> nodo = head;
		do {
			
			out.println(nodo);
			nodo = nodo.getNext();
		} while (nodo != null);
	}
	
	public void insert(Nodo<T> novo)
	{
		novo.setNext(head);
		head = novo;
		
		if (tail == null)
			tail = head;
	}

	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		if (anterior == tail) {
			tail.setNext((Nodo<T>)novo);
			tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
		}
	}

	public void append(Nodo<T> novo)
	{
		tail.setNext(novo);
		tail = novo;
	}
	
	//public Nodo<T> find(T dado){
		
/*	public static void main(String[] args)
	{
		ListaEncadeada<String> lista = new ListaEncadeada<String>();
		
		lista.insert(new Nodo<String>("Rafael"));
		lista.insert(new Nodo<String>("Tiago"), lista.getHead());
		lista.append(new Nodo<String>("Mauro"));
		lista.insert(new Nodo<String>("Carlos"));
		
		lista.print();
	}*/
	
	public String toString(){
		Nodo nodo = head;
		String lista=null;
		while(!nodo.equals(tail))
		{
			lista=(String) nodo.getChave() +" ";
			lista+= (String) nodo.getData() + "\n";
		}
		
		return lista;
	}
	
}
