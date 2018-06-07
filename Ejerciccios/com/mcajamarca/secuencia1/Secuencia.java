package com.mcajamarca.secuencia1;

public class Secuencia {
	
	public static double sumatoriaSecuencia(int n){
		double sumaSecuencia = 0;
		for (double i = 1; i<= n; i ++){
			sumaSecuencia = sumaSecuencia + (1/i);
		}
		return sumaSecuencia;
	}
	
	public static void main(String[] args) {
		System.out.println(sumatoriaSecuencia(2));
	}

}
