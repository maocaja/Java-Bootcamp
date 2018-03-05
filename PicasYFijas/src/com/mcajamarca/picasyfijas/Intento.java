package com.mcajamarca.picasyfijas;

public final class Intento {
    
    private String intento;
    
    public Intento(String intento) {
    	
    	if ( intento.length() != PicasYFijas.TAMAÑO_NÚMERO_SECRETO ){
			throw new IllegalArgumentException("El número debe tener " + PicasYFijas.TAMAÑO_NÚMERO_SECRETO + " digitos");
		}else if(PicasYFijas.tieneNúmerosRepetidos(intento)){
			throw new IllegalArgumentException("El número no puede tener dígitos repetidos");
		}
    	this.intento = intento;
	}
    
	public String getIntento() {
		return intento;
	}

	public void setIntento(String intento) {
		this.intento = intento;
	}

	@Override
	public String toString() {
		return intento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intento == null) ? 0 : intento.hashCode());
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
		Intento other = (Intento) obj;
		if (intento == null) {
			if (other.intento != null)
				return false;
		} else if (!intento.equals(other.intento))
			return false;
		return true;
	}
	
	

    
}