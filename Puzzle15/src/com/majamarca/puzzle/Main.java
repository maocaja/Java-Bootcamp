package com.majamarca.puzzle;

import java.util.Scanner;

public class Main {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int [][] initialArrayBoard = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 0, 11 }, {13, 14, 15, 12}};
		int [][] goalArrayBoard    = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0 }};
		Board board = new Board(initialArrayBoard);
		Board goalBoard = new Board(goalArrayBoard);
		System.out.println(board.toString());
		while(!board.equals(goalBoard)){
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
