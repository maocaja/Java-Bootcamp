package com.mcajamarca.puzzle;

public class Game {
	
	public Game() {
	}
	
	public static void main(String[] args) {
		
		Board board = new Board(4, null);
		System.out.println(board.toString());
	}
}
