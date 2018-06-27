package com.majamarca.puzzle;

import java.util.HashMap;
import java.util.Map;

public final class Board {
	
	private final Map<Tile,Position> tilesMap    = new HashMap<>();
	private final Map<Tile,Position> goalMap     = new HashMap<>();
	private final Map<Position,Tile> positionsMap = new HashMap<>();
	private final int[][] GOAL = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0 }};
	private final int MOVEMENTS_TO_SHUFFLE = 10;
	private final int size;
	
	private Board(int [][] board){
		this.size = board.length;
		assert validateThatTheBoardIsSquare(board) : "La matriz no es cuadrada por favor validar";
		fillMaps(board);
	}
	
	public static Board of (int [][] board){
		return new Board(board);
	}
	
	public static Board shufflingOf (int [][] board){
		Board shuffleBoard = new Board(board);
		shuffleBoard.shuffleMaps();
		return shuffleBoard;
	}
	
	private boolean validateThatTheBoardIsSquare(int[][] board) {
		for (int indexX = 0; indexX < board.length; ++indexX) {
			if (board[indexX].length != board.length){
				return false;
			}
		}
		return true;
	}
	
	private void fillMaps(int[][] board) {
		for (int indexX = 0; indexX < board.length; ++indexX) {
			for (int indexY = 0; indexY < board[indexX].length; ++indexY) {
				Position position = Position.of(indexX, indexY);
				setMaps(position, Tile.of(board[indexX][indexY]));
				setGoalMap(position, Tile.of(GOAL[indexX][indexY]));
			}
		}
	}
	
	private void setMaps(Position position, Tile tile) {
		this.positionsMap.put(position, tile);
		this.tilesMap.put(tile, position);
	}
	
	private void setGoalMap(Position position, Tile tile){
		goalMap.put(tile, position);
	}
	
	private Position seachPositionByValue(Tile tile) {
		if (tilesMap.containsKey(tile))
			return tilesMap.get(tile);
		else
			throw new AssertionError("El valor digitado no existe en el tablero, por favor validar");
	}
	
	private Tile searchTileByPosition(Position position){
		if (positionsMap.containsKey(position))
			return positionsMap.get(position);
		else
			throw new AssertionError("El valor digitado no existe en el tablero, por favor validar");
	}
	
	private void shuffleMaps() {
		int count = 1;
		while(count < MOVEMENTS_TO_SHUFFLE){
			Position zeroPosition     = seachPositionByValue(Tile.empty());
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
				builder.append(String.format("%-3s",positionsMap.get(position).toString()));
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
		return tilesMap.equals(goalMap);
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + MOVEMENTS_TO_SHUFFLE;
		result = prime * result + ((goalMap == null) ? 0 : goalMap.hashCode());
		result = prime * result + ((positionsMap == null) ? 0 : positionsMap.hashCode());
		result = prime * result + size;
		result = prime * result + ((tilesMap == null) ? 0 : tilesMap.hashCode());
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
		if (goalMap == null) {
			if (other.goalMap != null)
				return false;
		} else if (!goalMap.equals(other.goalMap))
			return false;
		if (positionsMap == null) {
			if (other.positionsMap != null)
				return false;
		} else if (!positionsMap.equals(other.positionsMap))
			return false;
		if (size != other.size)
			return false;
		if (tilesMap == null) {
			if (other.tilesMap != null)
				return false;
		} else if (!tilesMap.equals(other.tilesMap))
			return false;
		return true;
	}
}
