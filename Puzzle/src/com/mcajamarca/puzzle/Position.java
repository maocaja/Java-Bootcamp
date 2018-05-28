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
	
	public boolean isSafe() {
		return (this.x >= 0 && this.x < Utility.SIZE && y >= 0 && y < Utility.SIZE);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}