package com.mcajamarca.inversornúmero;

public class inversorNúmero {
	
	public static int invertirNúmero(int número){
		String nuevoNúmero = "0";
		for(int i = String.valueOf(número).length()-1; i >= 0; i --){
			nuevoNúmero = nuevoNúmero + ("" +String.valueOf(número).charAt(i));
		}
		return Integer.parseInt(nuevoNúmero);
	}
	
	public static void main(String[] args) {
		System.out.println(invertirNúmero(123456));
	}

}
