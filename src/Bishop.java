public class Bishop {
    //instance variables
    private int row;
    private int col;
    private boolean isBlack;
    public Bishop(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    } //constructor

    //verifies that the Bishop's movement follows the game rules, as it can move any distance as long as
    //movement is diagonal and there it not a piece in the way
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if(board.verifySourceAndDestination(this.row,this.col,endRow,endCol,isBlack)){
            if(Math.abs(endRow - this.row) == Math.abs(endCol - this.col)) {
                return board.verifyDiagonal(this.row, this.col, endRow, endCol);
            }
            return false;
        }
        return false;
    }//isMoveLegal
}//Bishop
