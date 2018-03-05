package com.mcajamarca.picasyfijas;

import java.util.Random;

public final class PicasYFijas {
	
	public static int TAMAÑO_NÚMERO_SECRETO = 4; 
    public static String [] NÚMEROS = {"0","1","2","3","4","5","6","7","8","9"};
    public static int NUMERO_DE_INTENTOS = 6;
    
	public PicasYFijas() {
		throw new AssertionError("Ésta clase no se debe instanciar");
	}
    
	public static String[] barajar (String [] número) {
    	Random random = new Random();
		int longitud = número.length;
	    while (longitud > 1) {
	        int aleatorio = random.nextInt(longitud--);
	        String temp = número[longitud];
	        número[longitud] = número[aleatorio];
	        número[aleatorio] = temp;
	    }
	    return número;
	}
	
	public static String[] barajar (String número) {
    	return barajar(convertirToArreglo(número));
	}
   
	public static String[] convertirToArreglo(String número) {
	    String[] arreglo = new String[número.length()];
	    for(int indice = 0; indice < número.length(); ++ indice){
	        arreglo[indice] = String.valueOf(número.charAt(indice));
	    }
	    return arreglo;
	}
	
	public static String convertirToString(String[] número) {
		StringBuilder builder = new StringBuilder();
	    for(int indice = 0; indice < número.length; ++ indice){
	    	builder.append(número[indice]);
	    }
	    return builder.toString();
	}
	
    public static String [] devuelveNúmeroSecreto(){
    	String [] arreglo = barajar(NÚMEROS); 
    	String [] arregloNuevo = new String [TAMAÑO_NÚMERO_SECRETO];
    	for (int indice = 0 ; indice < TAMAÑO_NÚMERO_SECRETO; ++ indice){
    		arregloNuevo[indice] = arreglo[indice];
    	}
    	return arregloNuevo;
    }
    
    public static boolean tieneNúmerosRepetidos(String númeroSecreto) {
		int contador = 0;
		for (int i = 0; i < númeroSecreto.length(); i++) {
            char dígito = númeroSecreto.charAt(i);
            for (int j = i + 1; j < númeroSecreto.length(); j++) {
                if (dígito == númeroSecreto.charAt(j)) {
                    contador += 1;
                }
            }
        }
		return (contador > 0) ? true: false;   
	}
}
