package com.mcajamarca.figuras;

public final class Figuras {
	
	public final static String PIXEL = "*";
	public final static String SALTO_DE_LÍNEA = String.format("%n"); 
	public final static String ESPACIO_EN_BlANCO = String.format(" ");
	public final static int TAMAÑO_POR_DEFECTO = 3;
	
	
	private static StringBuilder cuadrado(int tamaño){
		StringBuilder builder = new StringBuilder();
		int numeroEspacionsEnBlanco = 0;		
		if (tamaño < TAMAÑO_POR_DEFECTO){
			tamaño = TAMAÑO_POR_DEFECTO;
		}		
		builder.append(construirFigura(tamaño,tamaño,numeroEspacionsEnBlanco,0,0));
		return builder;
	}		
	
	private static StringBuilder Piramide(int tamaño){	
		StringBuilder builder = new StringBuilder();
		if (tamaño < TAMAÑO_POR_DEFECTO){
			tamaño = TAMAÑO_POR_DEFECTO;
		}
		int numeroEspaciosEnBlanco = tamaño - 1;
		builder.append(construirFigura(tamaño,1,numeroEspaciosEnBlanco,1,2));
		return builder;
	}

	private static StringBuilder construirFigura(int tamaño,int pixelesPorLinea,int numeroEspaciosEnBlanco, int incrementoEspacionsEnBlanco,int incrementoPixelesPorLinea ) {		
		StringBuilder builder = new StringBuilder();	
		for (int veces = 1; veces <= tamaño; ++veces) {
			builder.append(espaciosEnBlanco(numeroEspaciosEnBlanco))
				   .append(pixelesPorLinea(pixelesPorLinea));
			if (veces != tamaño){
				builder.append(SALTO_DE_LÍNEA);
			}
			numeroEspaciosEnBlanco  -= incrementoEspacionsEnBlanco;
			pixelesPorLinea         += incrementoPixelesPorLinea;			
		}
		return builder;
	}	
	
	public static String pixelesPorLinea(int numeroDePixeles){
		StringBuilder línea = new StringBuilder();
		for (int veces = 1; veces <= numeroDePixeles; ++veces ) {
			línea.append(PIXEL);
		}
		return línea.toString();
	}
	
	public static String espaciosEnBlanco(int numeroEspacios){
		StringBuilder lineaConEspacios = new StringBuilder(); 
		for (int veces = 1; veces <= numeroEspacios ; ++veces) {
			lineaConEspacios.append(" ");
		}
		return lineaConEspacios.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(Figuras.cuadrado(2));
		System.out.println(Figuras.Piramide(2));
	}
}
