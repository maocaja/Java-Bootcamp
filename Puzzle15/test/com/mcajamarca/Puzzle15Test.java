package com.mcajamarca;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.majamarca.puzzle.Board;

public class Puzzle15Test {
	
	@Test
	public void nextPositionOfTwelveThePuzzleIsEqualsToGoalBoard(){
		int [][] initialArrayBoard = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 0 }, {13, 14, 15, 12}};
		int [][] goalArrayBoard    = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
		Board board = new Board(initialArrayBoard);
		Board goalBoard = new Board(goalArrayBoard);
		assertThat(board.solve(12).toString(),equalTo(goalBoard.toString()));
	}
	
	@Test
	public void nextPositionOfSixIsTheSame(){
		int [][] initialArrayBoard = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 0 }, {13, 14, 15, 12}};
		Board board = new Board(initialArrayBoard);
		assertThat(board.solve(6).toString(),equalTo(board.toString()));
	}

}
