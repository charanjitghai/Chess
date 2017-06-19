/**
 * Created by cghai on 5/26/17.
 */

package moves;
import main.Square;
import main.Board;

public class VerticalMove implements Move{

    private static VerticalMove instance = null;
    private VerticalMove(){

    }
    public static VerticalMove getInstance(){
        if(instance == null)
            instance = new VerticalMove();
        return instance;
    }

    public boolean isValidMove(final Square source, final Square destination, final Board board){

        int sourceRow = source.getRow();
        char sourceCol = source.getCol();

        int destRow = destination.getRow();
        char destCol = destination.getCol();

        if(sourceCol != destCol )
            return false;


        int step;
        if(sourceRow < destRow)
            step = 1;
        else if(sourceRow > destRow)
            step = -1;
        else
            return false;

        for(int row = sourceRow + step; row != destRow ; row += step){
            Square square = board.getSquare(sourceCol, row);
            if(square.getPeice() != null)
                return false;
        }

        return true;

    }

}
