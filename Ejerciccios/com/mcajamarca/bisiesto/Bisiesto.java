package com.mcajamarca.bisiesto;

public class Bisiesto {
	
	public static boolean esBisiesto(int anio){
		if (anio%4 == 0){
			return (anio%400 == 0) ? true : (!(anio%100 == 0)) ? true: false;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		if (esBisiesto(2016)){
			System.out.println("Es anio bisiesto");
		}else{
			System.out.println("No es anio bisiesto");
		}
	}

}