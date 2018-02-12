package com.mcajamarca.figuras;

public class Rombo {
	
	private final int TAMAÑO_POR_DEFECTO = 3;
	private int altura;
	private StringBuilder rombo;
	private StringBuilder piramideArriba;
	private StringBuilder piramideAbajo;
	private StringBuilder lineaCentral;
	
	public Rombo() {		
		this.altura = TAMAÑO_POR_DEFECTO;
		inicializarRombo();
		construirRombo();		
	}
	
	public Rombo(int tamaño) {
		if (tamaño < 3){
			this.altura = TAMAÑO_POR_DEFECTO;
		}else{
			this.altura = tamaño;
		}
		inicializarRombo();
		construirRombo();
	}
	
	private void inicializarRombo(){
		rombo          = new StringBuilder();	
		piramideArriba = new StringBuilder();
		piramideAbajo  = new StringBuilder();	
		lineaCentral   = new StringBuilder();
	}
	
	private void construirPiramideArriba(){
		int alturaPiramideArriba    = this.altura - 1;
		int numeroEspacionsEnBlanco = this.altura - 1;
		int numeroDePrixeles = 1;
		for (int veces = 1; veces <= alturaPiramideArriba; ++veces) {
			
			piramideArriba.append(Impresora.espaciosEnBlanco(numeroEspacionsEnBlanco))
						  .append(Impresora.pintarLínea(numeroDePrixeles))
						  .append(Impresora.espaciosEnBlanco(numeroEspacionsEnBlanco));
			
			if (veces != alturaPiramideArriba){
				piramideArriba.append(Impresora.SALTO_DE_LINEA);
			}		
			numeroDePrixeles += 2;
			numeroEspacionsEnBlanco -= 1;			
		}		
		rombo.append(piramideArriba);
	}

	private void construirLineaCentral(){
		int numeroPixeles = (this.altura * 2) - 1;
		lineaCentral.append(Impresora.SALTO_DE_LINEA);
		lineaCentral.append(Impresora.pintarLínea(numeroPixeles));		
		lineaCentral.append(Impresora.SALTO_DE_LINEA);
		rombo.append(lineaCentral);
	}
	
	private void construirPiramideInversa(){
		piramideAbajo = piramideArriba;
		piramideAbajo.reverse();
		rombo.append(piramideAbajo);
	}
	
	private void construirRombo() {
		construirPiramideArriba();
		construirLineaCentral();
		construirPiramideInversa();	
	}

	public StringBuilder getRombo() {
		return rombo;
	}
	
	public static void main(String[] args) {
		System.out.println(new Rombo(4).getRombo());
		
	}
}
