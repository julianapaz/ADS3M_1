
public class Aresta 
{
	private Vertice verticeA;
	private Vertice verticeB;
	private double custo;
	private double distancia;
	
	public Aresta( Vertice verticeA, Vertice verticeB, double custo)
	{
		this.verticeA = verticeA;
		this.verticeB = verticeB;
		this.custo = custo;		
		//chama metodo que calcula distancia
	}
	
	
	public double getCusto()
	{
		return custo;
	}
	
	public double calculaDistancia()
	{
		return distancia; 
	}
	
	
	
	public String toString()
	{
		/*String aresta = "Vertice A: "+verticeA +
				" Vertice B: " + verticeB + " Custo: " + custo;*/
		
		String aresta = verticeA.toString() + " " + verticeB.toString();
		
		return aresta;
	}
}
