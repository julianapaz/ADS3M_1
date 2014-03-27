package com.senac.estruturas;
/** Classe que seria utilizada para realizar validacao(que nao foi implementada)
 * 	@deprecated durante o desenvolvimento do projeto notou-se desnecessario validacao
 */
public class Contato {
	
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
	public String toString() {
		String res = "Nome " + nome + " Telefone " + telefone;
		return res;
	}

}
