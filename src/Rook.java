//Written by Jonathan Castro, Castr385,Abdirahman Hassan, Hassa878.
public class Rook {
    //instance variables
    private int row;
    private int col;
    private boolean  isBlack;

    public Rook(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }//constructor

    //verifies that the Rook's movement follows the game rules, as it can move any distance as long as
    //movement is horizantal/vertical and there it not a piece in the way
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if(board.verifySourceAndDestination(this.row,this.col,endRow,endCol,isBlack)){
            if(this.row == endRow){
                return board.verifyVertical(this.row, this.col, endRow, endCol);
            }
            else if(this.col == endCol){
                return board.verifyHorizontal(this.row, this.col, endRow, endCol);
            }
            else{
                return false;
            }
        }
        return false;

    }//isMoveLegal
}//Rook
