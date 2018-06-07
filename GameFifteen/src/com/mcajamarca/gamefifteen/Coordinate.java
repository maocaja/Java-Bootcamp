package com.mcajamarca.gamefifteen;

public class Coordinate {
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean isSafe() {
		return (this.x >= 0 && this.x < Utility.SIZE && y >= 0 && y < Utility.SIZE);
	}
	
}
