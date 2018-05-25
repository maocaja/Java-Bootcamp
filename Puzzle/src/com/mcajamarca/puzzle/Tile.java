package com.mcajamarca.puzzle;

public final class Tile {
	
	private final int value;
	
	private Tile(final int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Tile of (int value){
		return new Tile(value);
	}
}
