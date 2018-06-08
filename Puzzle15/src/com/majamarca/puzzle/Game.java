package com.majamarca.puzzle;

import java.util.Scanner;

public class Game {
	
	private final int [][] goalBoard;
	
	public Game(int [][] goalBoard) {
		this.goalBoard = goalBoard;
	}
	
	public void play(){
		Board board = Board.shufflingOf(this.goalBoard);
		System.out.println(board.toString());
		while(!board.isSorted()){
			try {
				@SuppressWarnings("resource")
				Scanner keyboard = new Scanner(System.in);
				System.out.println("enter an tile:");
				int num = keyboard.nextInt();
				board = board.solve(num);
				System.out.println(board.toString());
			} catch (AssertionError error) {
				System.out.println(error.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		System.out.println(board.isSorted()? "El juego ha terminado, felicitaciones": "El juego no terminó");
	}

}
