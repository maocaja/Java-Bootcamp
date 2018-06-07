package com.mcajamarca.juego15;

import java.util.PriorityQueue;

public final class Juego15 {
	
	// Bottom, left, top, right
	private int[] fila = { 1, 0, -1, 0 };
	private int[] columna = { 0, -1, 0, 1 };
	private int dimension = 4;
	
	public int calcularCosto(int[][] inicial, int[][] objetivo) {
		int count = 0;
		int n = inicial.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (inicial[i][j] != 0 && inicial[i][j] != objetivo[i][j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	private Coordenada buscarCero(int[][] inicial) {
		for(int fila = 0 ; fila < inicial.length; ++fila ){
			for(int columna = 0 ; columna < inicial[fila].length; ++columna){
				if (inicial[fila][columna] == 0){
					return new Coordenada(fila,columna);
				}
			}
		}
		return Constantes.coordenadaVacia;
	}
	
	public boolean esCorrdenadaSegura(int x, int y) {
		return (x >= 0 && x < dimension && y >= 0 && y < dimension);
	}
	
	public void imprimirMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print( matrix[i][j] < 10 ? matrix[i][j] + "  ": matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void resolver(int[][] initial, int[][] goal) {
		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>(1000, (a, b) -> (a.costo   + a.level) - (b.costo + b.level));
		Coordenada coordenada = buscarCero(initial);
		Nodo raíz = new Nodo(initial, coordenada,coordenada, 0, null);
		raíz.costo = calcularCosto(initial, goal);
		pq.add(raíz);
		
		while (!pq.isEmpty()) {
			Nodo min = pq.poll();
			if (min.costo == 0) {
				imprimirPath(min);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
	            if (esCorrdenadaSegura(min.x + fila[i], min.y + columna[i])) {
	            	Coordenada coordenadaActual = new Coordenada(min.x, min.y);
	            	Coordenada coordenadaNueva = new Coordenada(min.x + fila[i], min.y + columna[i]);
	            	Nodo hijo = new Nodo(min.matrix, coordenadaActual, coordenadaNueva , min.level + 1, min);
	            	hijo.costo = calcularCosto(hijo.matrix, goal);
	            	pq.add(hijo);
	            }
	        }
		}
	}
	
	public void imprimirPath(Nodo raíz) {
		if (raíz == null) {
			return;
		}
		imprimirPath(raíz.padre);
		imprimirMatrix(raíz.matrix);
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[][] initial = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11,  0} ,{13, 14, 15, 12} };
		int[][] goal    = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0 } };
		
		Juego15 juego = new Juego15();
		juego.resolver(initial, goal);
	} 
	
}
