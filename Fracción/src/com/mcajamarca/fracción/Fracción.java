package com.mcajamarca.fracción;

public final class Fracción {
	private final int numerador;
	private final int denominador;
	
	public Fracción( final int numerador, final int denominador) {
		if (denominador == 0){
			throw new IllegalArgumentException("El denominador no debe ser cero");
		}
		int mcd = Operaciones.mcd(numerador,denominador);
		this.numerador   = numerador/mcd;
		this.denominador = denominador/mcd;
	}
	
	private Fracción opuesto(){
		return new Fracción(-this.numerador, this.denominador);
	}
	
	private Fracción inverso(){
		return new Fracción(this.denominador,this.numerador);
	}

	public Fracción más(Fracción otraFracción){
		int mcm = Operaciones.mcm(this.denominador, otraFracción.denominador);	
		int numeradorUno = (mcm /this.denominador) * this.numerador;
		int numeradorDos = (mcm /otraFracción.denominador) * otraFracción.numerador;
		int numerador = numeradorUno + numeradorDos;
		return  new Fracción(numerador, mcm);
	}
	
	public Fracción menos (Fracción otraFracción){
		return más(otraFracción.opuesto());
	}
	
	public Fracción por(Fracción otraFracción){
		int numerador = this.numerador * otraFracción.numerador;
		int denominador = this.denominador * otraFracción.denominador;
		return new Fracción(numerador, denominador);
	}
	
	public Fracción dividido (Fracción otraFracción){
		return por(otraFracción.inverso());
	}

	public int getNumerador() {
		return numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominador;
		result = prime * result + numerador;
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
		Fracción other = (Fracción) obj;
		if (denominador != other.denominador)
			return false;
		if (numerador != other.numerador)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%d/%d", this.numerador, this.denominador);
	}
	
}
