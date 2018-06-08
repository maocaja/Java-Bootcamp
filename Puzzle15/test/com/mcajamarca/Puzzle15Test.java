package com.mcajamarca;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import com.majamarca.puzzle.Board;

public class Puzzle15Test {
	
	@Test
	public void nextPositionOfTwelveWhereIsZero(){
		int [][] initialBoard = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 0  }, {13, 14, 15, 12}};
		int [][] nextlBoard   = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12 }, {13, 14, 15, 0 }};
		Board board = Board.of(initialBoard);
		assertThat(board.solve(12),equalTo(Board.of(nextlBoard)));
	}
	
	
	@Test
	public void nextPositionOfSixIsTheSame(){
		try {
			int [][] initialBoard = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 0 }, {13, 14, 15, 12}};
			Board board = Board.of(initialBoard);
			assertThat(board.solve(6),equalTo(board));
		} catch (AssertionError exception) {
			assertEquals("El valor digitado no se puede mover en el tablero, por favor validar", exception.getMessage());
	    }
	}

}
