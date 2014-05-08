package com.senac.estruturas;
public class Contato<T extends Comparable<T>> {
	
	private String nome;
	private String telefone;
	
	
	public Contato(){
		this.nome = null;
		this.telefone = null;
	}
	
	public Contato(String nome, String telefone){
		this.nome =nome;
		this.telefone = telefone;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//nao sei usar compare 
	public int compareTo(Contato<T> c) {
		return nome.compareTo(c.getNome());
	}
		
	
	public String toString() {
		String res = "Nome " + nome + " Telefone " + telefone;
		return res;
	}

	

}
