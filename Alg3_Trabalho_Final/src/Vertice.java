public class Vertice 
{
	//atributos
	private int identificador;
	private double coordenadaX;
	private double coordenadaY;
	
	private int anterior;
	private double custo;
	private boolean visitado;
	
	public Vertice(int identificacao, double coordenadaX, double coordenadaY)
	{
		this.identificador = identificacao;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		visitado = false;
	}
	
	public Vertice()
	{
		
	}
	
	public boolean visitado()
	{
		return visitado;
	}
	
	public void setVisitado(boolean v)
	{
		visitado = v;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificacao) {
		this.identificador = identificacao;
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
	
	
	public double getCusto()
	{
		return custo;
	}
	
	public void setAnterior(int anterior)
	{
		this.anterior = anterior;
	}
	
	public String toString()
	{
		String n = identificador + " " + coordenadaX + " " + coordenadaY;
		return n;
	}
}
