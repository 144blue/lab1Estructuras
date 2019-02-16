package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewtonRapson {

	static BufferedReader reader;

	public NewtonRapson() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public static double readDouble() throws IOException {
		return (new Double(reader.readLine())).doubleValue();
	}

	// Codificación de la función x cubica menos 4.3 por x cuadrada mas 4 por x
	// menos 17.2
	public static double f(double x) {
		return x * x * x - 4.3 * x * x + 4 * x - 17.2;
	}

	// Derivada de la funcion anterior
	public static double df(double x) {
		return 3 * x * x - 4.3 * 2 * x + 4;
	}

	public static void main(String[] args) {
		double x, y, epsilon;
		boolean done = false;
		NewtonRapson v = new NewtonRapson();

		try {
			System.out.print("x? ");
			x = readDouble();
			System.out.println();
			System.out.print("epsilon? ");
			epsilon = readDouble();
			do {
				y = f(x);
				System.out.println(x + " " + y);
				if (Math.abs(y) < epsilon)
					done = true;
				x -= y / df(x);
			} while (!done);
			System.out.println("Raiz de la Ecuación : " + x);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
