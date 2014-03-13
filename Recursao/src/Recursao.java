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

		start = System.currentTimeMillis();
		out.println("Fatorial 400:" + numero.fatorial(400));
		end = System.currentTimeMillis();
		out.println(end - start);

	}

}
