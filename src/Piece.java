//Written by Jonathan Castro, Castr385,Abdirahman Hassan, Hassa878.
import java.util.Scanner;

public class Piece {
    // Create Instance Variables
    char character;
    int row;
    int col;
    boolean isBlack;


    /**
     * Constructor.
     * @param character     The character representing the piece.
     * @param row           The row on the board the piece occupies.
     * @param col           The column on the board the piece occupies.
     * @param isBlack       The color of the piece.
     */
    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Determines if moving this piece is legal.
     * @param board     The current state of the board.
     * @param endRow    The destination row of the move.
     * @param endCol    The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        switch (this.character) {
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }

    /**
     * Sets the position of the piece.
     * @param row   The row to move the piece to.
     * @param col   The column to move the piece to.
     */
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public char getCharacter() {
        return character;
    }

    /**
     * Return the color of the piece.
     * @return  The color of the piece.
     */
    public boolean getIsBlack() {
        return isBlack; // returns true if the piece is black
    }

    /**
     * Handle promotion of a pawn.
     * @param row Current row of the pawn
     * @param isBlack Color of the pawn
     */

    //this method handles pawn promotion if it makes to the opposite end of board.
    public void promotePawn(int row, boolean isBlack) {             //turn if pawn is black, false if pawn is white
        Scanner scanner = new Scanner(System.in);
        if((isBlack && row == 7)) {                 //this checks if the pawn reached the last row or row 7

            while(true){                            //this loops until the user chooses a valid choise of promotion
                System.out.println("Select a piece for promotion: Queen, Rook, Bishop, or Knight");
                String input = scanner.nextLine();
                if(input.equals("Queen")){
                    this.character = '\u265b';
                    break;
                }
                if(input.equals("Bishop")){
                    this.character = '\u265d';
                    break;
                }
                if(input.equals("Rook")){
                    this.character = '\u265c';
                    break;
                }
                if(input.equals("Knight")) {
                    this.character = '\u265e';
                    break;
                }
                else{
                    System.out.println("Invalid choice.Try Again");
                    break;
                }
            }
            //change char to// this.char = unicode corresponds to piece of color
            //use a boolean to keep reading until user inputs correct input or while true

        }
        if((!isBlack && row == 0)) {                    //white Pawn promotion
            while (true) {
                System.out.println("Select a piece for promotion: Queen,Rook,Queen or Knight");
                String input = scanner.nextLine();
                if (input.equals("Queen")) {
                    this.character = '\u2655';
                    break;
                }
                if (input.equals("Bishop")) {
                    this.character = '\u2657';
                    break;
                }
                if (input.equals("Rook")) {
                    this.character = '\u2656';
                    break;
                }
                if (input.equals("Knight")) {
                    this.character = '\u2658';
                    break;
                } else {
                    System.out.println("Invalid choice.Try Again");      //this is an error message if the user inputs something different.
                    break;
                }
            }
        }
    }//promotePawn


    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {
        return "" + this.character;
    }


}//class
