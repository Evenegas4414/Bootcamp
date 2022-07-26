package cl.exql.Calculadora;

public class Calculadora {
	
	public  double restar(double a, double b) {
		return a - b;		
	}
	
	public double sumar(double a, double b) {
		return a + b;		
	}
	
	public double multiplicar(double a, double b) {
		return a * b;
	}
	
	public double dividir(double a, double b) {
		if (b == 0) {
			System.out.println("Error, la división por 0 es indefinida.");
			return 0;
		}
		return a / b;
	}

}
