package com.mcajamarca.juegoconway;

import java.util.Arrays;

public class Tablero {
	
	private Célula [][] tablero;
	
	public Tablero(Célula [][] tablero) {
		if (tablero.length == 0){
			throw new AssertionError("El tablero no puede estar vacío");
		}
		this.tablero = tablero;
	}
	
	public Tablero(char [][] tablero) {
		this(llenaTablero(tablero));
	}
	
	private static Célula [][] llenaTablero(char [][] tableroInicial){
		Célula [][] tablero = new Célula [tableroInicial.length][tableroInicial[0].length];		
		for (int i = 0; i < tableroInicial.length; ++i) {
			for (int j = 0; j < tableroInicial[i].length; ++j){
				tablero[i][j] = Célula.equivale(tableroInicial[i][j]);
			}
		}
		return tablero;
	}
	
	private Tablero inicializaTablero(){
		Célula [][] tablero = new Célula [this.tablero.length][this.tablero[0].length];
		return new Tablero(tablero);
	}
	
	public Tablero tableroFuturo(){
		Tablero tableroFuturo = inicializaTablero();		
		for (int i= 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++){
            	int vecinosVivos = vecinosVivos(i, j);
				tableroFuturo.tablero[i][j] = tablero[i][j].evalúaCélula(vecinosVivos);
			}
		}
		return tableroFuturo;
	}
	
	public int  vecinosVivos(int x, int y){
		int contadorCélulasVivas = 0;
		int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};
		for (int i = 0; i < 8; ++i) {
		   int nx = x + dx[i];
		   int ny = y + dy[i];
		   try {
			   if (tablero[nx][ny] == Célula.VIVA){
				   contadorCélulasVivas += 1;
			   }			
		   } catch (Exception e) {
			  // e.printStackTrace();
		   }
		}
		return contadorCélulasVivas;
	}
	
	@Override
	public String toString() {
		StringBuilder tableroString = new StringBuilder();
		for (int i = 0; i < tablero.length; ++i) {
            for (int j = 0; j < tablero[i].length; ++j){
            	tableroString.append(tablero[i][j].toString());
			}
            tableroString.append(String.format("%n"));
		}
		return tableroString.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(tablero);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablero other = (Tablero) obj;
		if (!Arrays.deepEquals(tablero, other.tablero))
			return false;
		return true;
	}	
	
	
}