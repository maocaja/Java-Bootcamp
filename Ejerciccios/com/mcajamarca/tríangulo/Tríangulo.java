package com.mcajamarca.tríangulo;

public class Tríangulo {
	
	public static boolean esTrianguloVálido(int longitudUno,int longitudDos, int longitudTres){
		
		if (esLongitudMayor(longitudUno,longitudDos,longitudTres) && esVálido(longitudUno,longitudDos,longitudTres)){
			return true;
		}else if (esLongitudMayor(longitudDos,longitudUno,longitudTres) && esVálido(longitudDos,longitudUno,longitudTres)){
			return true;
		}else if (esLongitudMayor(longitudTres,longitudUno,longitudDos) && esVálido(longitudTres,longitudUno,longitudDos)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean esLongitudMayor(int longitudMayor,int ladoUno, int ladoDos){
		return ((longitudMayor >ladoUno && longitudMayor > ladoDos)) ? true :false;
	}
	
	public static boolean esVálido(int longitudMayor,int ladoUno, int ladoDos){
		return ((ladoUno + ladoDos) > longitudMayor) ? true :false;
	}
	
	public static void main(String[] args) {
		if(esTrianguloVálido(3,4,5)){
			System.out.println("Tríangulo válido");
		}else{
			System.out.println("Tríangulo no válido");
		}
	}

}
