package moves;

import main.Color;
import main.Square;
import main.Board;
/**
 * Created by cghai on 6/18/17.
 */
public class OneStepDiagonalKillMove implements Move {
    private static OneStepDiagonalKillMove instance = null;
    private OneStepDiagonalKillMove(){

    }
    public static OneStepDiagonalKillMove getInstance(){
        if(instance == null)
            instance = new OneStepDiagonalKillMove();
        return instance;
    }
    public boolean isValidMove(final Square source, final Square destination, final Board board){

        if(source.getPeice().getColor() == Color.WHITE){
            if(destination.getRow() != source.getRow() + 1)
                return false;
        }
        else{
            if(destination.getRow() != source.getRow() - 1)
                return false;
        }
        if(abs(destination.getCol() - source.getCol()) != 1)
            return false;
        if(destination.getPeice().getColor() == source.getPeice().getColor())
            return false;

        return true;
    }

    private int abs(int num){
        return Math.abs(num);
    }
}
