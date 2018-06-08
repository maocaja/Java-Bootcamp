package com.majamarca.puzzle;

import java.util.HashMap;
import java.util.Map;

public final class Tile {
	
	private final int value;
	private final static Tile EMPTY = new Tile(0);
	private static Map<Integer, Tile> tiles = new HashMap<>();
	
	private Tile(int value){
		this.value = value;
	}
	
	public static Tile of (int value){
		if (!tiles.containsKey(value)){
			tiles.put(value, new Tile(value));
		}
		return tiles.get(value);
	}

	public int getValue() {
		return value;
	}
	
	public static Tile empty() {
		return EMPTY; 
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

	@Override
	public String toString() {
		return String.format("%d", this.value);
	}
}
