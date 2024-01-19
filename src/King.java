public class King {
    //instance variables
    private int row;
    private int col;
    private boolean isBlack;

    public King(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }//constructor

    //checks if King's movement is in any direction, but only one away.
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        return (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack) && board.verifyAdjacent(this.row, this.col, endRow, endCol));
    }//isMoveLegal
}//King
