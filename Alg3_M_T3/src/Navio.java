
public class Navio {

	private String nome;
	private int tamanho;
	private int pedacos;
	private boolean destruido;
	
	
	public Navio()
	{
		this.nome = "Navio";
		this.tamanho = 0;
		this.destruido = false;
	}
	
	
	public Navio(String nome, int tamanho)
	{
		this.nome = nome;
		this.tamanho = tamanho;
		pedacos = tamanho;
		destruido = false;
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
		return destruido;		
	}
	
	public void recebeTiro()
	{
		if (!destruido)
		{
			pedacos --;			
			
			if (pedacos == 0)
				destruido = true;
		}
				
		
	}	
	
	public String toString()
	{
		String navioString = "Navio: " + nome + "\nTamanho: " + tamanho;
		
		return navioString;
	}
}
