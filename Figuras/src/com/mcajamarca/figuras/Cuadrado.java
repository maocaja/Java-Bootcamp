package com.mcajamarca.figuras;

public final class Cuadrado{
	
	private int tamanio;
	private StringBuilder cuadrado;
	private final int TAMANIO_POR_DEFECTO = 3;
	
	public Cuadrado() {
		this.tamanio = TAMANIO_POR_DEFECTO;
		inicializarVariables();
		construirCuadrado();
	}
	
	public Cuadrado(int tamanio) {
		if (tamanio < 3){
			this.tamanio = TAMANIO_POR_DEFECTO;
		}else{
			this.tamanio = tamanio;
		}
		inicializarVariables();
		construirCuadrado();
	}
	
	private void inicializarVariables(){
		cuadrado = new StringBuilder();
	}
	
	private void construirCuadrado(){
		for (int veces = 1; veces <= tamanio; veces++) {
			cuadrado.append(Impresora.pintarLínea(tamanio));
			if(veces != tamanio){
				cuadrado.append(Impresora.SALTO_DE_LINEA);
			}
		}
	}

	public StringBuilder getCuadrado() {
		return cuadrado;
	}
}
