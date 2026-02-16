package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		ChessMatch match = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while(!match.isCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(match, captured);
				System.out.println();
				System.out.print("source: ");
				ChessPosition source = UI.readChessPosition(sc);
				boolean[][] possibleMoves = match.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(match.getPieces(), possibleMoves);
				System.out.println()
				;
				System.out.print("target: ");
				ChessPosition target = UI.readChessPosition(sc);
				ChessPiece capturedPiece = match.perfomeChessPiece(source, target);
				
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				if (match.getPromoted() != null) {
					System.out.print("Enter piece for promotion (B/N/R/Q): ");
					String type = sc.nextLine();
					match.replacePromotedPiece(type);
				}
			}
			catch(ChessException e ) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e ) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
			
			UI.printMatch(match, captured);
		}
		
	}

}
