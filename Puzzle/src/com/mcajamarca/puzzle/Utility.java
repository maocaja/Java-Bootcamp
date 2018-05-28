package com.mcajamarca.puzzle;

public final class Utility {
	
	public static int SIZE = 4;
	public static int [] goal    = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0 };
	public static int [] initial = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,  0, 13, 14, 15, 12};
	public static Position EMPTY_POSITION = Position.of(SIZE + 1,SIZE + 1);
	public static int[] ROW = { 1, 0, -1, 0 };
	public static int[] COLUMN = { 0, -1, 0, 1 };
    
	public Utility() {
		throw new AssertionError("Ésta clase no se debe instanciar");
	}
	
}
