//Written by Jonathan Castro, Castr385,Abdirahman Hassan, Hassa878.
public class Knight {
    //instance variables
    private int row;
    private int col;
    private boolean isBlack;
    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    } //constructor

    //verify that the Knight's movement follows the rule of the game, as the knight can onlt move in and "L" shape
    //the knight can also move to a new position even if there is another piece blocking the direct path.
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if(board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)){
            if(Math.abs(this.col - endCol) == 2 && Math.abs(this.row - endRow ) == 1){
                return true;
            }
            else if(Math.abs(this.col - endCol) == 1 && Math.abs(this.row - endRow ) == 2){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }//isMoveLegal

    }//Knight
