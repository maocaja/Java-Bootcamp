package com.mcajamarca.picasyfijas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Juego {	
	
	private MenteMaestra menteMaestra;
	
	public Juego(MenteMaestra menteMaestra) {
		this.menteMaestra = menteMaestra;
	}
	public void jugar(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Ya tenemos el "lector"

		for (int i = 1 ; i < PicasYFijas.NUMERO_DE_INTENTOS; ++i ){
			System.out.println("Por favor digite numero");//Se pide un dato al usuario
		    try {
				Intento intento = new Intento(br.readLine());
				System.out.println("Intento: " + intento.toString());
				System.out.println("fijas: " + menteMaestra.fijas(intento.toString()));
				System.out.println("picas: " + menteMaestra.picas(intento.toString()));
				if(menteMaestra.picas(intento.toString())== PicasYFijas.TAMAÑO_NÚMERO_SECRETO){
					break;
				}
		    } catch (IOException e) {
				e.printStackTrace();
		    } 
		}
		System.out.println(menteMaestra.toString());
		
	}
	
	public static void main(String[] args) {
		MenteMaestra menteMaestra = new MenteMaestra();
		new Juego(menteMaestra).jugar();	
	}
}
