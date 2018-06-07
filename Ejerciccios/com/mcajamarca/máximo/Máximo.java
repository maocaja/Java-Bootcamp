package com.mcajamarca.máximo;

public class Máximo {
	
	public static int devolverMayorDeTresNúmeros(int númeroUno, int númeroDos, int númeroTres){
		if (númeroUno > númeroDos){
			return (númeroUno > númeroTres) ? númeroUno: númeroTres;
		}else{
			return (númeroDos > númeroTres) ? númeroDos: númeroTres;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(devolverMayorDeTresNúmeros(3,3,2));
	}
}
