
public class Jogador {
	
	private String nome;
	private int totalPontos;
	private boolean perdeu;
	
	
	public Jogador(String nome, int totalPontos)
	{
		this.nome = nome;
		this.totalPontos = totalPontos;
		perdeu = false;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTotalPontos() {
		return totalPontos;
	}

	public void setTotalPontos(int totalPontos) {
		this.totalPontos = totalPontos;
	}

	public void perdePonto()
	{
		if (perdeu == false)
		{
			totalPontos--;
			
			if(totalPontos == 0)
				perdeu = true;
		}
		
	}
	
	public void ganhaPonto(int pontos)
	{
		totalPontos= totalPontos + pontos;
	}
	
	public boolean perdeu()
	{
		return perdeu;
	}
	

	
}
