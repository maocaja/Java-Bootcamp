package com.mcajamarca.gamefifteen;
// a petición del usuario, que reciba parametros por linea de comando.
// el usuario escribe el numero, que sea adyacente con el cero? , y lo intercambia.
// evalua si el juego terminó, feliciotaciones, sino espera otro número.
public class Game {
	
	private Board board;
	private Board goalBoard;
	// Bottom, left, top, right
	private int[] fila = { 1, 0, -1, 0 };
	private int[] columna = { 0, -1, 0, 1 };
	
	public Game(Board board, Board goalBoard) {
		this.board = board;
		this.goalBoard = goalBoard;
	}
	
	public void solve() {
		Coordinate zeroCoordinate = board.seachZero();
	}
	
	private int cost() {
		int count = 0;
		Tile [][] board     = this.board.getBoard().clone();
		Tile [][] goalBoard = this.goalBoard.getBoard().clone();
		
		for (int indexRow = 0; indexRow < board.length; ++indexRow) {
			for (int indexCol = 0; indexCol < board[indexRow].length; indexCol++) {
				if (board[indexRow][indexCol].getValue() != 0 && 
				    board[indexRow][indexCol].getValue() != goalBoard[indexRow][indexCol].getValue()) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Board board = new Board(Utility.initial);
		Board goalBoard = new Board(Utility.goal);
		Game game = new Game(board, goalBoard);
		game.solve();
	}

	public Board getBoard() {
		return board;
	}

	public Board getGoalBoard() {
		return goalBoard;
	}

}
