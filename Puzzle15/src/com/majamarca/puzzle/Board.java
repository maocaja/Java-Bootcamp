package com.majamarca.puzzle;

import java.util.HashMap;
import java.util.Map;

public final class Board {
	
	private final Map<Tile,Position> tilesBoard = new HashMap<>();
	private final Map<Position,Tile> positionBoard = new HashMap<>();
	private final Map<Tile,Position> goalBoard = new HashMap<>();
	private final int MOVEMENTS_TO_SHUFFLE = 10;
	private final int size;
	
	public Board(int [][] board){
		this.size = board.length;
		assert validateThatTheBoardIsSquare(board) : "La matriz no es cuadrada por favor validar";
		fillMaps(board);
		shuffleMaps();
	}
	
	private boolean validateThatTheBoardIsSquare(int[][] board) {
		for (int indexX = 0; indexX < board.length; indexX++) {
			if (board[indexX].length != board.length){
				return false;
			}
		}
		return true;
	}
	
	private void fillMaps(int[][] board) {
		for (int indexX = 0; indexX < board.length; indexX++) {
			for (int indexY = 0; indexY < board[indexX].length; indexY++) {
				Position position = Position.of(indexX, indexY);
				Tile tile = Tile.of(board[indexX][indexY]);
				goalBoard.put(tile, position);
				setMaps(position, tile);
			}
		}
	}
	
	private void setMaps(Position position, Tile tile) {
		this.tilesBoard.put(tile, position);
		this.positionBoard.put(position, tile);
	}
	
	private Position seachPositionByValue(Tile tile) {
		if (tilesBoard.containsKey(tile))
			return tilesBoard.get(tile);
		else
			throw new AssertionError("El valor digitado no existe en el tablero, por favor validar");
	}
	
	private Tile searchTileByPosition(Position position){
		if (positionBoard.containsKey(position))
			return positionBoard.get(position);
		else
			throw new AssertionError("El valor digitado no existe en el tablero, por favor validar");
	}
	
	private void shuffleMaps() {
		int count = 1;
		while(count < MOVEMENTS_TO_SHUFFLE){
			Position zeroPosition  = seachPositionByValue(Tile.empty());
			Position neighborPosition = zeroPosition.searchNeighborPosition();
			if(neighborPosition.isSafe(this.size)){
				Tile tile = searchTileByPosition(neighborPosition);
				move(neighborPosition, zeroPosition, tile);
				++count;
			}
		}
	}

	private void move(Position valuePosition, Position zeroPosition, Tile tile){
        setMaps(zeroPosition, tile);
        setMaps(valuePosition, Tile.empty());
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int indexX = 0; indexX < 4; indexX++) {
			for (int indexY = 0; indexY < 4; indexY++) {
				Position position = Position.of(indexX, indexY);
				builder.append(String.format("%-3s",positionBoard.get(position).toString()));
			}
			builder.append(String.format("%n"));
		}
		return builder.toString();
	}
	
	public Board solve(int value) {
		Position valuePosition = seachPositionByValue(Tile.of(value));
		Position zeroPosition  = seachPositionByValue(Tile.empty());
		if (valuePosition.isNeighbor(zeroPosition)){
			move(valuePosition,zeroPosition,Tile.of(value));
		}else{
			throw new AssertionError("El valor digitado no se puede mover en el tablero, por favor validar");
		}
		return this;
	}
	
	public boolean isSorted(){
		return tilesBoard.equals(goalBoard);
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + MOVEMENTS_TO_SHUFFLE;
		result = prime * result + ((goalBoard == null) ? 0 : goalBoard.hashCode());
		result = prime * result + ((positionBoard == null) ? 0 : positionBoard.hashCode());
		result = prime * result + size;
		result = prime * result + ((tilesBoard == null) ? 0 : tilesBoard.hashCode());
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
		if (MOVEMENTS_TO_SHUFFLE != other.MOVEMENTS_TO_SHUFFLE)
			return false;
		if (goalBoard == null) {
			if (other.goalBoard != null)
				return false;
		} else if (!goalBoard.equals(other.goalBoard))
			return false;
		if (positionBoard == null) {
			if (other.positionBoard != null)
				return false;
		} else if (!positionBoard.equals(other.positionBoard))
			return false;
		if (size != other.size)
			return false;
		if (tilesBoard == null) {
			if (other.tilesBoard != null)
				return false;
		} else if (!tilesBoard.equals(other.tilesBoard))
			return false;
		return true;
	}
}
