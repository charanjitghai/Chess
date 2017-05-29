/**
 * Created by cghai on 5/28/17.
 */

public class DiagonalMove implements Move {

    private static DiagonalMove instance = null;

    private DiagonalMove(){

    }

    public static DiagonalMove getInstance(){
        if(instance == null)
            instance = new DiagonalMove();
        return instance;
    }

    public boolean isValidMove(Square source, Square destination, Board board){

        int sourceRow = source.getRow();
        char sourceCol = source.getCol();

        int destRow = destination.getRow();
        char destCol = destination.getCol();

        if(abs(sourceRow - destRow) != abs(sourceCol - destCol))
            return false;


        if(sourceRow == destRow)
            return false;


        int rowStep;
        int colStep;

        if(sourceRow < destRow)
            rowStep = 1;
        else
            rowStep = -1;

        if(sourceCol < destCol)
            colStep = 1;
        else
            colStep = -1;
        int row = sourceRow + rowStep;
        char col = (char)(sourceCol + colStep);
        for(; row != destRow && col != destCol; row += rowStep, col += colStep ){
            Square square = board.getSquare(col, row);
            if(square.getPeice() != null)
                return false;
        }

        return true;

    }

    private int abs(int num){
        return Math.abs(num);
    }
}
