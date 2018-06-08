package com.majamarca.puzzle;

public final class Position {
	
	private final int x;
	private final int y;
	
	private Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public static Position of (int x, int y){
		return new Position(x, y);
	}
	
	public boolean isNeighbor(Position other){
		boolean isXNeighbor = (this.x == other.x) && Math.abs(other.y - this.y) == 1;
		boolean isYNeighbor = (this.y == other.y) && Math.abs(other.x - this.x) == 1;
		return isXNeighbor || isYNeighbor;
	}
	
	public Position searchNeighborPosition() {
		int[] row    = { 1,  0, -1, 0 };
		int[] col    = { 0, -1,  0, 1 };
		int index = (int)(Math.random() * ((3 - 0) + 1)) + 0;
		return Position.of(this.x + row[index], this.y + col[index]);
	}
	
	public boolean isSafe(int size) {
		return (this.x >= 0 && x < size && this.y >= 0 && y < size);
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
	
	@Override
	public String toString() {
		return String.format("(%d, %d)", this.x, this.y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
}
