package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		
		Board board = new Board(8,8);
		
		System.out.println(board);
		
		Position position = new Position(3,5);
		
		System.out.println(position);
		
		ChessMatch match = new ChessMatch();
		UI.printBoard(match.getPieces());
	}

}
