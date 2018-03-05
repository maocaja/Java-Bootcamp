package com.mcajamarca.picasyfijas;

public final class MenteMaestra {

	private NúmeroSecreto númeroSecreto;
	
	public MenteMaestra() {
		piensaNúmeroSecreto();
	}
	
	private void piensaNúmeroSecreto() {
		this.númeroSecreto = new NúmeroSecreto();
	}

	MenteMaestra(String númeroSecreto) {
		this.númeroSecreto = new NúmeroSecreto(númeroSecreto);
	}
	
	public int picas (String númeroRetador){
		return this.númeroSecreto.picas(númeroRetador);
	}
	
	public int fijas (String númeroRetador){
		return this.númeroSecreto.fijas(númeroRetador);
	}
	
	public NúmeroSecreto getNúmeroSecreto() {
		return númeroSecreto;
	}	
	
	public String toString(){
		return númeroSecreto.getNúmeroSecreto();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((númeroSecreto == null) ? 0 : númeroSecreto.hashCode());
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
		MenteMaestra other = (MenteMaestra) obj;
		if (númeroSecreto == null) {
			if (other.númeroSecreto != null)
				return false;
		} else if (!númeroSecreto.equals(other.númeroSecreto))
			return false;
		return true;
	}

}
