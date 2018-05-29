package com.mcajamarca.puzzle;

import java.util.HashMap;
import java.util.Map;

public final class Board {
	private int size;
	private Map<Position,Tile> board = new HashMap<Position,Tile>();
	
	public Board(int size, int[] numbers) {
		this.size = size;
		fillBoard(numbers);
	}
	
	private void fillBoard(int[] numbers) {
		int index = 0;
		for (int indexRow = 0; indexRow < this.size; ++indexRow) {
			for (int indexCol = 0; indexCol < this.size; ++indexCol) {
				board.put(Position.of(indexRow,indexCol),Tile.of(numbers[index]));
				++index;
			}
		}
	}

	private Position seachPositionOfValue(int value) {
		for(int indexRow = 0 ; indexRow < this.size; ++indexRow ){
			for(int indexCol = 0 ; indexCol < this.size; ++indexCol){
				Position position = Position.of(indexRow, indexCol);
				if (board.get(position).getValue() == value){
					return position;
				}
			}
		}
		return Utility.EMPTY_POSITION;
	}
	
	public Board solve(int value) {
		Position valuePosition = seachPositionOfValue(value);
		Position zeroPosition = seachPositionOfValue(0);
		return searchAround(valuePosition,zeroPosition);
	}
	
	private void move(Position valuePosition, Position zeroPosition){
         Tile tile = board.get(valuePosition);
         Tile zeroTile = board.get(zeroPosition);
         board.put(zeroPosition, tile);
         board.put(valuePosition, zeroTile);
	}
	private Board searchAround(Position valuePosition, Position zeroPosition) {
		
		for (int index = 0; index < this.size; ++index) {
			Position goalPosition = Position.of(valuePosition.getX() + Utility.ROW[index], 
					                            valuePosition.getY() + Utility.COLUMN[index]);
			if (goalPosition.isSafe() && goalPosition.equals(zeroPosition)){
				move(valuePosition, goalPosition);
				break;
			}
        }
		return this;
	}
	
	public boolean isSolvable() {
		int count = 0;
		int[] numbers = convertMapToArray();
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] != 0 && numbers[j] != 0 && numbers[i] > numbers[j]) {
						count++;
					}
				}
			}
		return count % 2 == 0;
	}

	private int[] convertMapToArray() {
		int [] numbers = new int [this.size * this.size];
		int index = 0;
		for(int indexRow = 0 ; indexRow < this.size; ++indexRow ){
			for(int indexCol = 0 ; indexCol < this.size; ++indexCol){
				Position position = Position.of(indexRow, indexCol);
				numbers[index] = board.get(position).getValue();
				++index;
			}
		}
		return numbers;
	}

	public String toString() {
		   StringBuilder builder = new StringBuilder();
		   for (int i = 0; i < this.size ;++i) {
		      for (int j = 0; j < this.size; ++j) {
		         Position position = Position.of(i, j);
		         builder.append(board.get(position).getValue() < 10 ? board.get(position).getValue() + "  ": board.get(position).getValue() + " ");
		      }
		      builder.append(String.format("%n"));
		   }
		   return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board == null) ? 0 : board.hashCode());
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (board == null) {
			if (other.board != null)
				return false;
		} else if (!board.equals(other.board))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
}
