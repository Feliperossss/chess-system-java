package chess;

import boardgame.Position;

public class ChessPosition {
	private int row;
	private char column;
	
	public ChessPosition(int row, char column) {
		if(column < 'a' ||	column > 'h' || row < 1 || row> 8	) 
		throw new ChessException("error: invalid position ");
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public char getColumn() {
		return column;
	}
	
	
	
	public Position toPosition(int row, char column) {
		int rowPosition = 8- row;
		int columnPosition = column - 'a';
		return new Position(rowPosition,columnPosition);
	}
	
	public static	ChessPosition fromPosition(Position position) {
		return new ChessPosition( position.getRow(), (char)('a' + position.getColumn()));
		
	}

	@Override
	public String toString() {
		return ""+ column + row;
	}


	
	
}
