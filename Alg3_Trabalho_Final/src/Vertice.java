public class Vertice 
{
	//atributos
	private int identificacao;
	private double coordenadaX;
	private double coordenadaY;
	
	private Vertice anterior;
	private double custo;
	private boolean visitado;
	
	public Vertice(int identificacao, double coordenadaX, double coordenadaY)
	{
		this.identificacao = identificacao;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		visitado = false;
	}
	
	public Vertice()
	{
		
	}
	
	public boolean foiVisitado()
	{
		return visitado;
	}

	public int getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}

	public double getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(double coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public double getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(double coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
	public String toString()
	{
		String n = identificacao + " " + coordenadaX + " " + coordenadaY;
		return n;
	}
}
