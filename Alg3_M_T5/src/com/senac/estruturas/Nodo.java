package com.senac.estruturas;

public class Nodo<T extends Comparable<T>> implements Comparable<Contato<T>>
{

	private Contato contato;
	private Nodo esquerda;
	private Nodo direita;
	
	public Nodo()
	{
	}
	
	public Nodo(Contato contato)
	{
		this.contato = contato;
		this.esquerda = null;
		this.direita = null;
	}
	
	public Contato getContato()
	{
		return contato;
	}
	
	public void setContato(Contato c)
	{
		contato = c;
	}
	
	public Nodo getDireita()
	{
		return direita;
	}
	
	public void setDireita(Nodo novo)
	{
		this.direita = novo;
	}
 	
 	
	
	public Nodo getEsquerda()
	{
		return esquerda;
	}
	
	public void setEsquerda(Nodo novo)
	{
		this.esquerda = novo;
	}

	
	
	
	/*public String toString(){
		String res = getContato()() + " "
				+ getDado();
		
		return res;
	}*/
	
/*	
	public Nodo insere(Nodo no, Contato c)
	{
		if(no == null)
		{
			no.setContato(c);
			no.setDireita(null);
			no.setEsquerda(null);
		}
		else
		{
			int cmp = no.compareTo(c);
				if(cmp < 0)
				{
					no.setDireita(insere(no, c));
				}
				else
				{
					no.setEsquerda(insere(no, c));
				}
		}
		return no;
	}*/

	@Override
	public int compareTo(Contato<T> o) {
		
		return getContato().getNome().compareTo(contato.getNome());
	}
	
	public void print(Nodo no)
	{
		if(no != null)
		{
			no.print(no.getDireita());
			System.out.println(no.getContato());
			no.print(no.getEsquerda());
		}
	}

}
