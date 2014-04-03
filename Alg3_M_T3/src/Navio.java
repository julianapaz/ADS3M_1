
public class Navio {

	private String nome;
	private int tamanho;
	private int pedacos;
	
	public Navio(String nome, int tamanho)
	{
		this.nome = nome;
		this.tamanho = tamanho;
		pedacos = tamanho;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getPedacos() {
		return pedacos;
	}

	public void setPedacos(int pedacos) {
		this.pedacos = pedacos;
	}

	public boolean destruido()
	{
		return pedacos==0;		
	}
	
	public void recebeDisparo()
	{
		if (pedacos>0)
			pedacos--;
	}	
}
