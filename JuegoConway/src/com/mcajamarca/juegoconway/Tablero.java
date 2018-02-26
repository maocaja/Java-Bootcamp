package com.mcajamarca.juegoconway;

public class Tablero {
	
	private Célula [][] tablero;
	
	public Tablero(char [][] tablero) {
		if (tablero.length == 0){
			throw new AssertionError("El tablero no puede estar vacío");
		}
		llenaTablero(tablero);		
	}
	
	public Tablero(Célula [][] tablero) {
		this.tablero = tablero;
	}
	
	private void llenaTablero(char [][] tableroInicial){
		this.tablero = new Célula [tableroInicial.length][tableroInicial[0].length];		
		for (int i = 0; i < tableroInicial.length; ++i) {
            for (int j = 0; j < tableroInicial[i].length; ++j){
				tablero[i][j] = Célula.equivale(tableroInicial[i][j] + "");
			}
		}
	}
	private Célula[][] inicializaTablero(){
		return new Célula [tablero.length][tablero[0].length]; 
	}
	
	public Célula [][] tableroFuturo(){
		int numeroCélulasVivas = 0;
		Célula tableroFuturo [][] = inicializaTablero();		
		for (int i= 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++){
				tableroFuturo[i][j] = tablero[i][j];
				numeroCélulasVivas = Célula.célulasVévas(i, j, tablero);
				tableroFuturo[i][j] = Célula.evaléaCélula(numeroCélulasVivas, tablero[i][j]);
			}
		}
		return tableroFuturo;
	}
	
	@Override
	public String toString() {
		StringBuilder tableroString = new StringBuilder();
		for (int i = 0; i < tablero.length; ++i) {
            for (int j = 0; j < tablero[i].length; ++j){
            	tableroString.append(tablero[i][j].getPixel());
			}
            tableroString.append(String.format("%n"));
		}
		return tableroString.toString();
	}	

}
