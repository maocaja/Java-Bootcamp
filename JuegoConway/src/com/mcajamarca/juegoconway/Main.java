package com.mcajamarca.juegoconway;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
	private Path path;
	private List<String> plano ;
	private int filas;
	private int columnas;
	private int generaciones;
	private char [][] mundoInicial;
	
	public Main(Path path) {
		this.path = path;
		cargarPlano();
		cargarVariables();
		cargaMundoInicial();
		iniciarJuego();
	}
	
	private  void cargarPlano(){
		try {
			plano = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void cargarVariables(){
		filas        = Integer.parseInt(plano.get(0).charAt(0) + "");
		columnas     = Integer.parseInt(plano.get(0).charAt(2) + "");
		generaciones = Integer.parseInt(plano.get(0).charAt(4) + "");
	}
	
	private void cargaMundoInicial(){
		mundoInicial = new char[filas][columnas];
		int filas = 0;
		for (int i = 1; i < plano.size(); ++i){
			mundoInicial[filas] = plano.get(i).toCharArray();
			filas++;
		}
	}
	
	public void iniciarJuego(){
		Tablero tablero = new Tablero(mundoInicial);    	
		for (int i = 1; i <= generaciones ; ++i) {
			System.out.println(tablero.toString());    		
			Tablero tableroFuturo = tablero.tableroFuturo(); 
			tablero = tableroFuturo;
		}
	}
	
	public static void main (String [] args){
		Path plano = Paths.get("src/com/mcajamarca/juegoconway/conway.txt");
		new Main(plano);
	}
    
}