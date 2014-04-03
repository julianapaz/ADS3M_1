
public class Jogador {
	
	private String nome;
	private int totalPontos;
	
	
	public Jogador(String nome, int totalPontos)
	{
		this.nome = nome;
		this.totalPontos = totalPontos;
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
		if (totalPontos>0)
			totalPontos--;
	}
	
	public void ganhaPonto()
	{
		totalPontos+=3;
	}
	
	public boolean perdeu()
	{
		return totalPontos==0;
	}
	
}
