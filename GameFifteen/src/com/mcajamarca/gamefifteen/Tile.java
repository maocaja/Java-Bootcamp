package com.mcajamarca.gamefifteen;

public class Tile {
	
	private int value;
	private Coordinate coordinate;
	
	public Tile(int value, Coordinate coordinate) {
		this.value = value;
		this.coordinate = coordinate;
	}
	
	public int getValue() {
		return value;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}
}
