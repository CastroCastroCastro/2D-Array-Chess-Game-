//Written by Jonathan Castro, Castr385, Abdirahman Hassan, Hassa878.
import java.util.Scanner;
//this is the main class responsible for running the chess game
public class Game {
    public static void main(String[] args) {
        Board myBoard = new Board();        //board initialization

        boolean whiteTurn = true;
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", myBoard);   //fen.load is used to initialize the board to the standard chess starting position.
        while(!myBoard.isGameOver()) {   //this insures that players can keep making moves till game is over.
            if (whiteTurn) {
                System.out.println("It is white's turn to play");
            } else {
                System.out.println("It is black's turn to play");
            } //this if and else statements display which player's turn it is.

            System.out.println("Board: \n");
            Scanner scanner = new Scanner(System.in);
            System.out.println(myBoard);    //displays the board.
            System.out.println("What is your move? (Format: [start row] [start col] [end row] [end col]");
            String whiteMove = scanner.nextLine();  //user input for moves
            String[] input = whiteMove.split(" "); //split user's input with a space as a delimiter
            int startRow = Integer.parseInt(input[0]);
            int startCol = Integer.parseInt(input[1]);
            int endRow = Integer.parseInt(input[2]);
            int endCol = Integer.parseInt(input[3]);  //then parse user's parts into integers representing starting & ending row/col.

            if (myBoard.verifySourceAndDestination(startRow,startCol,endRow,endCol, !whiteTurn) && (myBoard.getPiece(startRow, startCol) != null) && (myBoard.getPiece(startRow, startCol).getIsBlack() == !whiteTurn) && (myBoard.movePiece(startRow, startCol, endRow, endCol))) {
                if (myBoard.getPiece(endRow, endCol) != null) {
                    if (myBoard.getPiece(endRow, endCol).character == '\u265f' || (myBoard.getPiece(endRow, endCol).character == '\u2659')) {
                        myBoard.getPiece(endRow, endCol).promotePawn(endRow, myBoard.getPiece(endRow, endCol).getIsBlack());
                    }//second if myBoard.getPiece
                }//first if myBoard.getPiece
                whiteTurn = !whiteTurn; //then turn is changed
            }
            else {
                System.out.println("Invalid move. Try again.");
            }



        }//while

        if (whiteTurn) {
        System.out.println("Black won the game.");
    }                                                       //these statements will announce the winner.
    else {                                                  // if it's white's turn when the game ends, then black won and vice versa.
        System.out.println("White won the game.");

    }
    }//main
}//class
