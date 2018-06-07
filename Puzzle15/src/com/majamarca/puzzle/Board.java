package com.majamarca.puzzle;

import java.util.HashMap;
import java.util.Map;

public final class Board {
	
	private final Map<Tile,Position> board = new HashMap<>();
	private final int size;
	
	public Board(int [][] board){
		this.size = board.length;
		assert validateThatTheBoardIsSquare(board) : "La matriz no es cuadrada por favor validar";
		traverseArray(board);
		assert validateThatThereAreNoRepeatedNumbers(board, Tile.empty().getValue()): "La matriz tiene números repetidos, por favor validar";
		fillMap(board);
	}
	
	private boolean validateThatTheBoardIsSquare(int[][] board) {
		for (int indexX = 0; indexX < board.length; indexX++) {
			if (board[indexX].length != board.length){
				return false;
			}
		}
		return true;
	}
	
	private void traverseArray(int[][] board) {
		for (int indexX = 0; indexX < board.length; indexX++) {
			for (int indexY = 0; indexY < board[indexX].length; indexY++) {
				validateThatThereAreNoRepeatedNumbers(board,board[indexX][indexY]);
			}
		}
	}
	
	private boolean validateThatThereAreNoRepeatedNumbers(int[][] board, int value){
		int count = 0;
		for (int indexX = 0; indexX < board.length; indexX++) {
			for (int indexY = 0; indexY < board[indexX].length; indexY++) {
				if (board[indexX][indexY] == value)
					++count;
			}
		}
		
		if (count > 1){
			return false;//throw new AssertionError("El valor " + value + " se repite, por favor validar");
		}else if (count == 0){
			return false;//throw new AssertionError("El valor " + value + " no existe, por favor validar");
		}else{
			return true;
		}
	}
	
	private void fillMap(int[][] board) {
		for (int indexX = 0; indexX < board.length; indexX++) {
			for (int indexY = 0; indexY < board[indexX].length; indexY++) {
				Position position = Position.of(indexX, indexY);
				Tile tile = Tile.of(board[indexX][indexY]);
				this.board.put(tile, position);
			}
		}
	}
	
	private int [][] converMapToArray(){
		int [][] printBoard = new int [this.size][this.size];
		for (int index = 0; index < this.board.size(); index++) {
			Position position = this.board.get(Tile.of(index));
			printBoard[position.getX()][position.getY()] = Tile.of(index).getValue(); 		
		}
		return printBoard;
	}
	
	private Position seachPositionOfValue(int value) {
		if (board.containsKey(Tile.of(value)))
			return board.get(Tile.of(value));
		else
			throw new AssertionError("El valor digitado no existe en el tablero, por favor validar");
	}
	
	private void move(Position valuePosition, Position zeroPosition, int value){
        board.put(Tile.of(value),zeroPosition);
        board.put(Tile.empty(),valuePosition);
	}
	
	public Board solve(int value) {
		Position valuePosition = seachPositionOfValue(value);
		Position zeroPosition = seachPositionOfValue(Tile.empty().getValue());
		if (valuePosition.isNeighbor(zeroPosition)){
			move(valuePosition,zeroPosition,value);
		}
		return this;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int [] row : converMapToArray()) {
			for (int value : row) {
				builder.append(String.format("%-3s",value));
			}
			builder.append(String.format("%n"));
		}
		return builder.toString();
	}
}


