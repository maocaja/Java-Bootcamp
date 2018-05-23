	package com.mcajamarca.juego15;

public final class Nodo {

	public Nodo padre;
	public int[][] matrix;
	
	// Blank tile cordinates
	public int x, y;
	
	// Number of misplaced tiles
	public int costo;
	
	// The number of moves so far
	public int level;
	
	public Nodo(int[][] matrix, Coordenada coordenada, Coordenada coordenadaNueva, int level, Nodo parent) {
		this.padre = parent;
		this.matrix = new int[matrix.length][];
		for (int i = 0; i < matrix.length; i++) {
			this.matrix[i] = matrix[i].clone();
		}
		
		// Swap value
		this.matrix[coordenada.getX()][coordenada.getY()]           = this.matrix[coordenada.getX()][coordenada.getY()] + 
																	  this.matrix[coordenadaNueva.getX()][coordenadaNueva.getY()];
		
		this.matrix[coordenadaNueva.getX()][coordenadaNueva.getY()] = this.matrix[coordenada.getX()][coordenada.getY()] - 
				                                                      this.matrix[coordenadaNueva.getX()][coordenadaNueva.getY()];
		
		this.matrix[coordenadaNueva.getX()][coordenadaNueva.getY()] = this.matrix[coordenadaNueva.getX()][coordenadaNueva.getY()] - 
																	  this.matrix[coordenadaNueva.getX()][coordenadaNueva.getY()];
		
		this.costo = Integer.MAX_VALUE;
		this.level = level;
		this.x = coordenadaNueva.getX();
		this.y = coordenadaNueva.getY();
	}
	
}