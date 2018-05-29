package com.mcajamarca.puzzle;

public class Game {
	
	private Board board;
	private Board goalBoard;
	
	public Game(Board board, Board goalBoard) {
		this.board = board;
		this.goalBoard = goalBoard;
	}
	
	public Board solve(int value){
		return board.solve(value);
	}
	
	public static void main(String[] args) {
		Board board = new Board(Utility.SIZE, Utility.initial);
		Board goalBoard = new Board(Utility.SIZE, Utility.goal);
		System.out.println("Puzzle");
		System.out.println(board.toString());
		System.out.println(board.isSolvable());
		Game game = new Game(board,goalBoard);
		game.solve(6);
	}
}
