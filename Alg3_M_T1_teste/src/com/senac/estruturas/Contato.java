package com.senac.estruturas;

public class Contato {
	private String nome;
	private String telefone;
	
	
	
	
	public Contato(){
		this.nome = null;
		this.telefone = null;
	}
	
	public Contato(String nome, String telefone){
		this.nome = nome;
		this.telefone = telefone;
	}
	
	
	protected String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected String getTelefone() {
		return telefone;
	}
	protected void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String toString(){
		String res = "Nome " + getNome() + "Telefone " + getTelefone();
		return res;
	}
	
	
}
