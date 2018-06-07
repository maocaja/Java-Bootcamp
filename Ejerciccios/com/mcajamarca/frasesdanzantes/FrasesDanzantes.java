package com.mcajamarca.frasesdanzantes;

public class FrasesDanzantes {
	
	public static void main(String[] args) {
		String frase = "En total serán protegidas 12.946 hectáreas";
		System.out.println(fraseDanzante(frase));
	}
	
	public static String fraseDanzante(String frase){
		String fraseDanzante = "";
		String[] tempFraseDanzante;
		tempFraseDanzante = frase.split(" ");
		for(int i =0; i < tempFraseDanzante.length ; i++){
			fraseDanzante = fraseDanzante + Character.toUpperCase(tempFraseDanzante[i].charAt(0)) 
										  + tempFraseDanzante[i].substring(1) + " ";
		}	
		return fraseDanzante;
	}

}
