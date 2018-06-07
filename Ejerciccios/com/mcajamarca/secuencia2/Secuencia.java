package com.mcajamarca.secuencia2;

public class Secuencia {
	
	public static float sumatoriaSecuencia(int n){
		
		float sumaSecuencia = 0;
		float denominador = 1;
		float numerador = 1;
		for (int i = 1; i<= n; i ++){
			sumaSecuencia = sumaSecuencia + (numerador/denominador);
			numerador = numerador + 2;
			denominador = denominador * 2;
		}
		return sumaSecuencia;
	}
	
	public static void main(String[] args) {
		System.out.println(sumatoriaSecuencia(2));
	}

}
