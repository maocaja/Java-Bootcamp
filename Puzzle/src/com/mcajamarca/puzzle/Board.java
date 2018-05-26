package com.mcajamarca.puzzle;

import java.util.HashMap;
import java.util.Map;

public final class Board {
	// posición es una clase interna
	private int size;
	private Map<Position,Tile> board = new HashMap<Position,Tile>();
	
	public Board(int size, int[] numbers) {
		this.size = size;
		fillBoard(numbers);
	}

	private void fillBoard(int[] numbers) {
		Position position = Position.of(0, 0);
		Tile tile = Tile.of(1);
		board.put(position,tile);
	}
	
	public String toString() {
		   StringBuilder builder = new StringBuilder();
		   for (int i = 0; i < 1 ;++i) {
		      for (int j = 0; j < 1; ++j) {
		         Position position = Position.of(i, j);
		         builder.append(board.get(position));
		      }
		      builder.append(String.format("%n"));
		   }
		   return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board == null) ? 0 : board.hashCode());
		result = prime * result + size;
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
		Board other = (Board) obj;
		if (board == null) {
			if (other.board != null)
				return false;
		} else if (!board.equals(other.board))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
}
