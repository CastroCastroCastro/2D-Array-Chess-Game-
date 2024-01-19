//Written by Jonathan Castro, Castr385,Abdirahman Hassan, Hassa878.
public class Queen {
    //instance variables
    private int row;
    private int col;
    private boolean isBlack;
    public Queen(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    } //constructor

    //verifies that the queen's movement follows the game rules, as it can move any distance in any direction if path
    ///is not blocked.
    public boolean isMoveLegal (Board board, int endRow, int endCol) {
        if(board.verifySourceAndDestination(this.row,this.col,endRow,endCol,isBlack)) {
            if(this.row == endRow) {
                return board.verifyVertical(this.row, this.col, endRow, endCol);
            }
            else if(this.col == endCol){
                return board.verifyHorizontal(this.row, this.col, endRow, endCol);
            }
            else if (Math.abs(endRow - this.row) == Math.abs(endCol - this.col)) {
                return board.verifyDiagonal(this.row, this.col, endRow, endCol);
                }
            else {
                return false;
            }
        }
        return false;

    }//isMoveLegal
}//Queen