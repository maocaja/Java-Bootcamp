package com.mcajamarca.truncar;

public class Truncar {

	public static int truncarNúmero(int número){
		String nuevoNúmero = "0";
		for(int i = 0; i < String.valueOf(número).length()-1; i ++){
			nuevoNúmero = nuevoNúmero + ("" +String.valueOf(número).charAt(i));
		}
		return Integer.parseInt(nuevoNúmero);
	}
	
	public static void main(String[] args) {
		System.out.println(truncarNúmero(123456));
	}
	
}
