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
	static double func(int[] a, double x) {
		double result=0;
		int id=a.length-1;
		
		for(int i=0; i<a.length;i++) {
			result+=a[i]*Math.pow(x,i+id);
			id-=2;
		}
		return result;
	}

	// Derivative of the above function
	// which is 3*x^x - 2*x
	static double derivFunc(int[] a,double x) {
		double result=0;
		int id=a.length-1;
		
		for(int i=0;i<a.length;i++) {
		//	System.out.println("grado: "+(i+id-1)+"\tdato: "+a[i]+"\tcohef: "+(i+id));
			result+=(i<=a.length-1)?a[i]*(i+id)*Math.pow(x,i+id-1):0;
			
			id-=2;
		}
		return result;
	}

	public static String methodNewtonRaphson(int[] a,double x) {
		String cadena="";
		double h = func(a,x) / derivFunc(a,x);
		while (Math.abs(h) >= EPSILON) {
			h = func(a,x) / derivFunc(a,x);

			// x(i+1) = x(i) - f(x) / f'(x)
			x = x - h;
		}

		cadena+="The value of the" + " root is : " + Math.round(x * 100.0) / 100.0+"\n";
		
		return cadena;
	}
	
	public static void main(String[] args) {
		
	
		int[] test= {0,0,0,0,0,0,0,1,2,0,2};
		int a=0;
		
		for(int i=0;i<test.length;i++)
			a=+test[i];
		
		System.out.println("nnnn"+NewtonRapson.func(test, 5));
		System.out.println(NewtonRapson.derivFunc(test, 5));
		
		System.out.println(NewtonRapson.methodNewtonRaphson(test,5));
		
		
	}
}
