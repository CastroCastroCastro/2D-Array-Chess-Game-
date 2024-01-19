//Written by Jonathan Castro, Castr385,Abdirahman Hassan, Hassa878.
import java.util.TreeMap;

public class Board {

    // a 2D array Instance variable
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8]; //creates an empty 8x8 board cells
    }//constructor

    // Accessor Methods

    public Piece getPiece(int row, int col) {
        return board[row][col]; //returns the "Piece" object at a specified location on board
    }//setPiece


    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece; //sets piece at specified location on board
    }//setPiece

    // Game functionality methods

    //movePiece return true checks if there is piece in startPos and if move is legal
    //then moves piece to endPos and updates position of piece then empties the startPos
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
            if(board[startRow][startCol] != null){
                if(board[startRow][startCol].isMoveLegal(this,endRow, endCol)){
                        board[endRow][endCol] = board[startRow][startCol];
                    board[endRow][endCol].setPosition(endRow,endCol);
                    board[startRow][startCol] = null;
                        return true; //indicates success
                    }
                }
        return false; //indicates failure
    }//movePiece

    //isGameOver checks the existence of both kings on Board. If one is missing,
    //game is over and returns true.
    public boolean isGameOver() {
        boolean whiteK = false;
        boolean blackK = false;
            for (int i = 0; i<= 7; i++){
                for (int j = 0; j<= 7; j++){
                    if(board[i][j] != null){
                        if(board[i][j].getCharacter() == '\u265a'){ //black king found
                            blackK = true;
                    }
                    if(board[i][j].getCharacter() == '\u2654'){ //white king found
                        whiteK = true;
                    }
                }
                }
            }
        return !(blackK && whiteK);
    }//isGameOver

    // Constructs a String that represents the Board object's 2D array.
    // Returns the fully constructed String.
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" ");
        for(int i = 0; i < 8; i++){
            out.append(" ");
            out.append(i);
        }
        out.append('\n');
        for(int i = 0; i < board.length; i++) {
            out.append(i);
            out.append("|");
            for(int j = 0; j < board[0].length; j++) {
                out.append(board[i][j] == null ? "\u2001|" : board[i][j] + "|");
            }
            out.append("\n");
        }
        return out.toString();
    }//toString

    public void clear() {
        for(int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col ++) {
                board[row][col] = null; //loops through every cell of the array and sets them to null
            }
        }
    }//clear

    // Movement helper functions

    //verifySourceAndDestination avoids not exceed the board bound (8x8), and returns true if the startPos is not null and the color
    //of the peice matches the player's color, and endPos os empty or occupied by the opposite color
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if((startRow >= 0 && startRow <= 7) && (endRow >= 0 && endRow <= 7)
            && (startCol >= 0 && startCol <= 7) && (endCol >= 0 && endCol <= 7)) {
            if (board[startRow][startCol] != null && board[startRow][startCol].getIsBlack() == isBlack) {
                if(board[endRow][endCol] == null || board[endRow][endCol].getIsBlack() != isBlack)
                    return true; //checks pass
            }
        }
        return false; //one or more checks failed
    }//verifySourceAndDestination

    // verifyAdjacent checks if two given positions on board are directly next to each other whether Hor,Ver, or Diog
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        return Math.abs(startRow - endRow) <= 1 && Math.abs(startCol - endCol) <= 1;
    }//verifyAdjacent

    //verifyHorizontal checks if the move is strictly horizontal and
    //ensures that all cells b/w the starPos and endPos are empty.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if(startRow != endRow) {
            return false;
        }
        if (startCol < endCol) {
            for (int x = startCol + 1; x < endCol; x++) { //moves piece to the right
                if (board[startRow][x] != null) {
                    return false;
                }
            }
        } else{
            for (int i = endCol + 1; i < startCol; i++) { //move piece to the left
                if (board[startRow][i] != null) {
                    return false;
                }
            }
        }
        return true;
    }//verifyHorizontal

//verifyVertical is similar to the previous method but checks for vertical moves
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if(startCol != endCol) {
            return false;
        }
        if (startRow < endRow) {
            for (int i = startRow + 1; i < endRow; i++) {
                if (board[i][startCol] != null)
                    return false;
            }
        }
        for (int i = startRow - 1; i > endRow; i--){
            if(board[i][startCol] != null) {
                return false;
            }
        }
        return true;
    }//verifyVertical

//verifyDiogonal verifies the move is diogonal and that all cells b/w the startPos and endPos are empty
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        if((startRow - startCol) == (endRow - endCol)) { //checks if move is diagonal
            for (int x = Math.min(startRow, endRow) + 1; x < Math.max(startRow, endRow); x++) {
                if(board[x][(startCol - startRow) + x] != null) {
                    return false;
                }
            }
            return true;
        }else if (startRow + startCol == endRow + endCol) { //loop through diagonal left to right, check if null
            for(int i = Math.min(startRow,endRow)+1; i < Math.max(startRow, endRow); i++){
                if (board[i][(startRow + startCol) - i] != null) {
                    return false;
                }
            }
            return true;
        }//else if
        else{
            return false;
        }

    }//verifyDiogonal
}//Board Class