package com.mcajamarca.puzzle;

import java.util.HashMap;
import java.util.Map;

public final class Board {
	// posición es una clase interna
	private int size;
	// valor, posición
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
		StringBuilder boardString = new StringBuilder();
		Position position = Position.of(0, 0);
		Tile tile = board.get(position);
		System.out.println(tile.getValue());
		boardString.append(board.size() + " tile:" + tile.getValue());
		return boardString.toString();
	}
}
