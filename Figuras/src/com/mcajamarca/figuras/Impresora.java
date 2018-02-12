package com.mcajamarca.figuras;

public final class Impresora {
	
	public final static String ESPACIO_EN_BLANCO = " "; 
	public final static String SALTO_DE_LINEA = String.format("%n"); 
	public final static String PIXEL = "*";
	
	public Impresora() {
		 throw new AssertionError("Clase nos instanciable");
	}
	
	public static String espaciosEnBlanco(int numeroDeEspacios) {
		StringBuilder espaciosEnBlanco = new StringBuilder();
		espaciosEnBlanco.append(llenarLinea(numeroDeEspacios,ESPACIO_EN_BLANCO));
	    return espaciosEnBlanco.toString(); 
	}
	
	public static String pintarLínea(int numeroDeVeces){
		StringBuilder lineaDeFigura = new StringBuilder();
		lineaDeFigura.append(llenarLinea(numeroDeVeces,PIXEL));
		return lineaDeFigura.toString();
	}

	private static StringBuilder llenarLinea(int numeroDeVeces, String contenido) {
		StringBuilder linea = new StringBuilder();
		for (int veces = 1; veces <= numeroDeVeces; ++veces) {
			linea.append(contenido);
		}
		return linea;
		
	}
}
