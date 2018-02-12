package com.mcajamarca.figuras;

public class Piramide{
	
	private final int TAMANIO_POR_DEFECTO = 3;
	private int altura;
	private StringBuilder piramide;
	
	public Piramide() {
		this.altura = TAMANIO_POR_DEFECTO;
		inicializarPiramide();
		construirPiramide();
	}
	
	public Piramide(int tamaño){
		if (tamaño < 3){
			this.altura = TAMANIO_POR_DEFECTO;
		}else{
			this.altura = tamaño;
		}
		inicializarPiramide();
		construirPiramide();
	}
	
	private void inicializarPiramide (){
		piramide = new StringBuilder();
	}
	
	private void construirPiramide(){
		int numeroDeEspacios = altura - 1;
		int númeroDePixeles = 1;
		for (int veces = 1; veces <= altura; ++veces) {
			piramide.append(Impresora.espaciosEnBlanco(numeroDeEspacios))
					.append(Impresora.pintarLínea(númeroDePixeles))
					.append(Impresora.espaciosEnBlanco(numeroDeEspacios));
			if(veces != altura){
				piramide.append(Impresora.SALTO_DE_LINEA);
			}
			numeroDeEspacios -= 1;
			númeroDePixeles  += 2;
		} 
	}

	public StringBuilder getPiramide() {
		return piramide;
	}
}
