package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch match;

	public King(Board board, Color color, ChessMatch match) {
		super(board, color);
		this.match = match;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null  && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// nw
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// ne
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// sw
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// sw
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// especial move castling
		if(getMoveCount() == 0  && !match.isCheck()) {
			// especialmove castling kingside rook
			Position posT1 = new Position(position.getRow(),position.getColumn()+3);
			if(testRookCastling(posT1)){
				Position pos1 =  new Position(position.getRow(),position.getColumn() + 1 );
				Position pos2 =  new Position(position.getRow(),position.getColumn() + 2 );
				if(getBoard().piece(pos1) == null && getBoard().piece(pos2) == null) {
					mat[position.getRow()][position.getColumn()+2] = true;
				}
			}
			Position posT2 = new Position(position.getRow(),position.getColumn() - 4);
			if(testRookCastling(posT2)){
				Position pos1 =  new Position(position.getRow(),position.getColumn() - 1 );
				Position pos2 =  new Position(position.getRow(),position.getColumn() - 2 );
				Position pos3 =  new Position(position.getRow(),position.getColumn() - 3 );
				if(getBoard().piece(pos1) == null && getBoard().piece(pos2) == null && getBoard().piece(pos3) == null) {
					mat[position.getRow()][position.getColumn()-2] = true;
				}
			}
		}

		return mat;
	}

}
