package com.mcajamarca.puzzle;

public final class Position {
	private final int x;
	private final int y;
	
	private Position(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Position of (int x, int y){
		return new Position(x, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}