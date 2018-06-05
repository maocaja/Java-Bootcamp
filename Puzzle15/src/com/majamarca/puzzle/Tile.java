package com.majamarca.puzzle;

public final class Tile {
	
	private final int value;
	public static final int EMPTY_VALUE = 0;
	
	private Tile(int value){
		this.value = value;
	}
	
	public static Tile of (int value){
		return new Tile(value);
	}

	public int getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
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
		Tile other = (Tile) obj;
		if (value != other.value)
			return false;
		return true;
	}
}
