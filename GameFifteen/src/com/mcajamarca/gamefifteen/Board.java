package com.mcajamarca.gamefifteen;
/*
 * Faltaría: 
 */
public class Board {
	
	private Tile[][] board;
	
	public Board(int[] numbers) {
		newBoard(numbers);
	}

	private void newBoard(int [] numbers){
		this.board = new Tile [Utility.SIZE][Utility.SIZE];
		fillBoard(this.board,numbers);
	}
	
	private void fillBoard(Tile[][] board, int[] numbers) {
		int index = 0; 
		for(int indexRow = 0; indexRow < board.length; ++indexRow) {
			for (int indexCol = 0; indexCol < board[indexRow].length; ++indexCol) { 
				// implementar fábrica para construir tiles y coordinate
				Tile tile = new Tile(numbers[index],new Coordinate(indexRow, indexCol)); 
				board[indexRow][indexCol] = tile;
				++index;
			} 
		}
	}
	
	public Coordinate seachZero() {
		int index = Utility.SIZE -1;
		for(int indexRow = 0 ; indexRow < board.length; ++indexRow ){
			for(int indexCol = 0 ; indexCol < board[indexRow].length; ++indexCol){
				if (board[indexRow][indexCol].getValue() == 0){
					return new Coordinate(indexRow,indexCol);
				}
			}
		}
		return new Coordinate(index,index);
	}
	
	public String toString() {
		StringBuilder tableroString = new StringBuilder();
		for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j){
            	tableroString.append(board[i][j].getValue() < 10 ? board[i][j].getValue() + "  ": board[i][j].getValue() + " ");
			}
            tableroString.append(String.format("%n"));
		}
		return tableroString.toString();
	}

	public Tile[][] getBoard() {
		return board;
	}
}
