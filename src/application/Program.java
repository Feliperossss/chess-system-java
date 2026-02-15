package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		ChessMatch match = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			UI.clearScreen();
			UI.printBoard(match.getPieces());
			System.out.println();
			System.out.print("source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.print("target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			 ChessPiece capturedPiece = match.perfomeChessPiece(source, target);
		}
		
	}

}
