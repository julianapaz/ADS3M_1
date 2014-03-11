import java.util.Scanner;

public class Hello {

	private static Scanner entrada;

	public static void main(String[] args) {
		String nome = "Juliana";
		entrada = new Scanner(System.in);

		System.out.println("Digite seu nome: ");
		nome = entrada.next();

		System.out.println("Hello, " + nome);
	}

}
