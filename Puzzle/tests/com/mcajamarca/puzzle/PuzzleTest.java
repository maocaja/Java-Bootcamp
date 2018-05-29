package com.mcajamarca.puzzle;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class PuzzleTest {
	
	@Test
	public void puzzleThatFinishFifteenFouteenIsNotSolvable(){
		int [] unsolvable = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 14, 0};
		Board board = new Board(Utility.SIZE, unsolvable);
		assertThat(board.isSolvable(),equalTo(Boolean.FALSE));
	}
	@Test
	public void puzzleIsSolvable(){
		int [] initialBoard = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
		Board board = new Board(Utility.SIZE, initialBoard);
		Board goalBoard = new Board(Utility.SIZE, Utility.goal);
		assertThat(board.toString(),equalTo(goalBoard.toString()));
	}
	
	@Test
	public void nextPositionOfTwelveThePuzzleWillBeSolved(){
		int [] initialBoard = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 13, 14, 15, 12};
		Board board = new Board(Utility.SIZE, initialBoard);
		Board goalBoard = new Board(Utility.SIZE, Utility.goal);
		assertThat(board.solve(12).toString(),equalTo(goalBoard.toString()));
	}
	
	@Test
	public void nextPositionOfSixIsTheSame(){
		int [] initialBoard = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 13, 14, 15, 12};
		Board board = new Board(Utility.SIZE, initialBoard);
		assertThat(board.solve(6).toString(),equalTo(board.toString()));
	}
}
