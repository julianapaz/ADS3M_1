import static java.lang.System.out;

public class Recursao {

	// primeiro criar um CRITERIO DE PARADA
	public double fatorial(double n) {
		if (n <= 1)
			return 1;
		return fatorial(n - 1) * n;
	}

	public int fatorialIter(int n) {
		int fat = 1;
		for (int x = 2; x <= n; x++)
			fat *= x;
		return fat;
	}
	
	public double fibonacci(int n) {
		if (n<2) 
			return 1;
		else
			return fibonacci(n-1) + fibonacci(n-2);

		
	}
	
	public double fibonacciIter(int n){
		double f0 = 1;
		double f1 = 1;
	}

	public static void main(String[] args) {
		Recursao numero = new Recursao();
		long start, end;

		start = System.currentTimeMillis();
		out.println("Fatorial 5:" + numero.fatorial(5));
		end = System.currentTimeMillis();
		out.println(end - start);

		start = System.currentTimeMillis();
		out.println("Fatorial 25:" + numero.fatorial(25));
		end = System.currentTimeMillis();
		out.println(end - start);

		start = System.currentTimeMillis();
		out.println("Fatorial 35:" + numero.fatorial(35));
		end = System.currentTimeMillis();
		out.println(end - start);

		start = System.currentTimeMillis();
		out.println("Fatorial 40:" + numero.fatorial(40));
		end = System.currentTimeMillis();
		out.println(end - start);

		/******************************************/
		start = System.currentTimeMillis();
		out.println("Fibonnaci 5" + numero.fibonacci(5));
		end = System.currentTimeMillis();
		out.println(end - start);
		
		start = System.currentTimeMillis();
		out.println("Fibonnaci 10" + numero.fibonacci(10));
		end = System.currentTimeMillis();
		out.println(end - start);
		
		start = System.currentTimeMillis();
		out.println("Fibonnaci  20" + numero.fibonacci(20));
		end = System.currentTimeMillis();
		out.println(end - start);
		
		start = System.currentTimeMillis();
		out.println("Fibonnaci 30" + numero.fibonacci(30));
		end = System.currentTimeMillis();
		out.println(end - start);
		start = System.currentTimeMillis();
		out.println("Fibonnaci 33" + numero.fibonacci(33));
		end = System.currentTimeMillis();
		out.println(end - start);
		
		
		start = System.currentTimeMillis();
		out.println("Fibonnaci 35" + numero.fibonacci(35));
		end = System.currentTimeMillis();
		out.println(end - start);
		
		start = System.currentTimeMillis();
		out.println("Fibonnaci 37" + numero.fibonacci(37));
		end = System.currentTimeMillis();
		out.println(end - start);
		
		start = System.currentTimeMillis();
		out.println("Fibonnaci 40" + numero.fibonacci(40));
		end = System.currentTimeMillis();
		out.println(end - start);
		
		start = System.currentTimeMillis();
		out.println("Fibonnaci 50" + numero.fibonacci(50));
		end = System.currentTimeMillis();
		out.println(end - start);

	}

}
