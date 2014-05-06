package com.senac.estruturas;

public class Nodo
{

	private String dado;
	private String chave;
	private Nodo esquerda;
	private Nodo direita;
	
	public Nodo()
	{
	}
	
	public Nodo(String chave, String dado)
	{
		this.dado = dado;
		this.chave = chave;
		this.esquerda = null;
		this.direita = null;
	}
	
	public String getDado()
	{
		return dado;
	}
	
	public void setDado(String dado)
	{
		this.dado = dado;
	}
	
	public String getChave()
	{
		return chave;
	}
	
	public void setChave(String chave)
	{
		this.chave = chave;
	}
	
	public Nodo getDireita()
	{
		return direita;
	}
	
	public void setDireita(Nodo direita)
	{
		this.direita = direita;
	}
 	
	public Nodo getEsquerda()
	{
		return esquerda;
	}
	
	public void setEsquerda(Nodo esquerda)
	{
		this.esquerda = esquerda;
	}
//ver com prof - generics
	public int compareTo(Nodo r) {
		return chave.compareTo(r.getChave());
	}
	
	
	public String toString(){
		String str = getChave() + " " + getDado();
		
		return str;
	}
	
	public int compareTo(String str)
	{
		return chave.compareTo(str);
	}

}
