package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewtonRapson {

	static final double EPSILON = 0.001;

	public NewtonRapson() {
		
	}

	// An example function whose solution
	// is determined using Bisection Method.
	// The function is x^3 - x^2 + 2
	static double func(double x) {
		return x * x * x - x * x + 2;
	}

	// Derivative of the above function
	// which is 3*x^x - 2*x
	static double derivFunc(double x) {
		return 3 * x * x - 2 * x;
	}

	static void newtonRaphson(double x) {
		double h = func(x) / derivFunc(x);
		while (Math.abs(h) >= EPSILON) {
			h = func(x) / derivFunc(x);

			// x(i+1) = x(i) - f(x) / f'(x)
			x = x - h;
		}

		System.out.print("The value of the" + " root is : " + Math.round(x * 100.0) / 100.0);
	}
}
