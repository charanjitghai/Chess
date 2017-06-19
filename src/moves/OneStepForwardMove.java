package moves;

import main.Board;
import main.Color;
import main.Square;

/**
 * Created by cghai on 6/18/17.
 */
public class OneStepForwardMove implements Move {
    private static OneStepForwardMove instance = null;
    private OneStepForwardMove(){

    }
    public static OneStepForwardMove getInstance(){
        if(instance == null)
            instance = new OneStepForwardMove();
        return instance;
    }
    public boolean isValidMove(final Square source, final Square destination, final Board board){

        if(source.getCol() != destination.getCol())
            return false;


        if(destination.getPeice() != null)
            return false;

        if(source.getPeice().getColor() == Color.WHITE){
            if(destination.getRow() - source.getRow() != 1)
                return false;
            return true;
        }
        else{
            if(destination.getRow() - source.getRow() != -1)
                return false;
            return true;
        }
    }
}
