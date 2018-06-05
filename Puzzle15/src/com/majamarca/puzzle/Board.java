package com.majamarca.puzzle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Board {
	
	private final Map<Tile,Position> board = new HashMap<>();
	private final int size;
	
	public Board(int [][] board){
		this.size = board.length;
		validateArray(board);
		traverseArray(board);
		validateArrayByValue(board, Tile.EMPTY_VALUE);
		fillHashMap(board);
	}
	
	private void validateArray(int[][] board) {
		for (int indexX = 0; indexX < board.length; indexX++) {
			if (board[indexX].length != board.length){
				throw new AssertionError("La matriz no es cuadrada, por favor validar");
			}
		}
	}
	
	private void traverseArray(int[][] board) {
		for (int indexX = 0; indexX < board.length; indexX++) {
			for (int indexY = 0; indexY < board[indexX].length; indexY++) {
				validateArrayByValue(board,board[indexX][indexY]);
			}
		}
	}
	
	private void validateArrayByValue(int[][] board, int value){
		int count = 0;
		for (int indexX = 0; indexX < board.length; indexX++) {
			for (int indexY = 0; indexY < board[indexX].length; indexY++) {
				if (board[indexX][indexY] == value)
					++count;
			}
		}
		
		if (count > 1){
			throw new AssertionError("El valor " + value + " se repite, por favor validar");
		}else if (count == 0){
			throw new AssertionError("El valor " + value + " no existe, por favor validar");
		}
	}
	
	private void fillHashMap(int[][] board) {
		for (int indexX = 0; indexX < board.length; indexX++) {
			for (int indexY = 0; indexY < board[indexX].length; indexY++) {
				Position position = Position.of(indexX, indexY);
				Tile tile = Tile.of(board[indexX][indexY]);
				this.board.put(tile, position);
			}
		}
	}
	
	private int [][] convertHashMapToArray(){
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
        board.put(Tile.of(Tile.EMPTY_VALUE),valuePosition);
	}
	
	public Board solve(int value) {
		Position valuePosition = seachPositionOfValue(value);
		Position zeroPosition = seachPositionOfValue(Tile.EMPTY_VALUE);
		if (valuePosition.isNeighbor(zeroPosition)){
			move(valuePosition,zeroPosition,value);
		}
		return this;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int [] row : convertHashMapToArray()) {
			for (int value : row) {
				builder.append(String.format("%-3s",value));
			}
			builder.append(String.format("%n"));
		}
		return builder.toString();
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int [][] initialArrayBoard = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 0, 11 }, {13, 14, 15, 12}};
		int [][] goalArrayBoard    = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0 }};
		Board board = new Board(initialArrayBoard);
		Board goalBoard = new Board(goalArrayBoard);
		System.out.println(board.toString());
		while(!board.toString().equals(goalBoard.toString())){
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Digite casilla que desea mover");
			int num = keyboard.nextInt();
			Board newBoard = board.solve(num);
			if (newBoard.toString().equals(board.toString())){
				System.out.println("La casilla, " + num + " no se puede mover");
			}
			System.out.println(board.toString());
		}
	}
}


