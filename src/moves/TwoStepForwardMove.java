package moves;

import main.Board;
import main.Color;
import main.Square;

/**
 * Created by cghai on 6/20/17.
 */
public class TwoStepForwardMove implements Move{

    private static TwoStepForwardMove instance = null;

    private TwoStepForwardMove(){

    }

    public static TwoStepForwardMove getInstance(){
        if(instance == null)
            instance = new TwoStepForwardMove();
        return instance;
    }

    public boolean isValidMove(final Square source, final Square destination, final Board boad){

        if(source.getCol() != destination.getCol())
            return false;

        if(destination.getPeice() != null)
            return false;

        if(source.getPeice().getColor() == Color.WHITE){
            if(source.getRow() != 2)
                return false;
            if(destination.getRow() != source.getRow() + 2)
                return false;

            return true;
        }
        else{
            if(source.getRow() != 7)
                return false;
            if(destination.getRow() != source.getRow() - 2)
                return false;
            return true;
        }
    }

}
