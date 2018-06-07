package com.mcajamarca.picasyfijas;

import java.util.Arrays;

public final class NúmeroSecreto {
	
	private final String [] númeroSecreto;
	   
	public NúmeroSecreto(String númeroSecreto) {
		if ( númeroSecreto.length() != PicasYFijas.TAMAÑO_NÚMERO_SECRETO ){
			throw new IllegalArgumentException("El número debe tener " + PicasYFijas.TAMAÑO_NÚMERO_SECRETO + " digitos");
		}else if(PicasYFijas.tieneNúmerosRepetidos(númeroSecreto)){
			throw new IllegalArgumentException("El número no puede tener dígitos repetidos");
		}
		this.númeroSecreto = PicasYFijas.convertirAArreglo(númeroSecreto);
	}
	
	public NúmeroSecreto() {
		this.númeroSecreto = PicasYFijas.devuelveNúmeroSecreto();
	}
	
	public int picas(String númeroRetador) {
		String [] arregloNúmeroRetador = PicasYFijas.convertirAArreglo(númeroRetador);
		int picas = 0;
		for (int i = 0; i < this.númeroSecreto.length; i++) {
			for (int j = 0; j < arregloNúmeroRetador.length; j++) {
				if (i != j && (this.númeroSecreto[i].equals(arregloNúmeroRetador[j]))){
					picas ++;
				}
			}
		}
		return picas;
	}
	
	public int fijas(String númeroRetador) {
		String [] arregloNúmeroRetador = PicasYFijas.convertirAArreglo(númeroRetador);
		int fijas = 0;
		for (int i = 0; i < this.númeroSecreto.length; i++) {
			if (this.númeroSecreto[i].equals(arregloNúmeroRetador[i])){
				fijas ++;
		    }
		}
		return fijas;
	}
	
	public String getNúmeroSecreto() {
		return PicasYFijas.convertirACadena(númeroSecreto);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(númeroSecreto);
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
		NúmeroSecreto other = (NúmeroSecreto) obj;
		if (!Arrays.equals(númeroSecreto, other.númeroSecreto))
			return false;
		return true;
	}
	
	
}