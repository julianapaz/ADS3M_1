package com.senac.estruturas;

public class NodoInt
{

	private int valor;
	private NodoInt esquerda;	
	private NodoInt direita;
	
	public NodoInt()
	{
	}
	
	public NodoInt(int v)
	{
		this.valor = v;
		this.esquerda = null;
		this.direita = null;
	}
	
	public int getValor()
	{
		return valor;
	}
	
	public void setValor(int v)
	{
		valor = v;
	}
	
	public NodoInt getDireita()
	{
		return direita;
	}
	
	public void setDireita(NodoInt novo)
	{
		this.direita = novo;
	}
 	
 	
	
	public NodoInt getEsquerda()
	{
		return esquerda;
	}
	
	public void setEsquerda(NodoInt novo)
	{
		this.esquerda = novo;
	}

	
	
	
	/*public String toString(){
		String res = getContato()() + " "
				+ getDado();
		
		return res;
	}*/
	
	
	/*public NodoInt insere(NodoInt no, int v)
	{
		if(no==null)
		{
			setValor(v);
		}
			
	
		if( v < no.getValor() )
		{
			if ( no.getEsquerda() == null )
				no.setEsquerda(new NodoInt(v));
			else
				no.setEsquerda( insere(no.getEsquerda(), v) );
			
		}
		
		else
		{
			if( no.getDireita() == null )
				no.setDireita( new NodoInt(v) );
			else
				no.setDireita(insere(no.getDireita(), v));
		}
		return no;
	}*/


	
	
	
}
