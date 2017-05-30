/**
 * Created by cghai on 5/29/17.
 */
public class KnightMove implements Move {
    private static KnightMove instance = null;
    private KnightMove(){

    }
    public static KnightMove getInstance(){
        if(instance == null)
            instance = new KnightMove();
        return instance;
    }

    public boolean isValidMove(Square source, Square destination, Board board){

        int sourceRow = source.getRow();
        char sourceCol = source.getCol();

        int destRow = destination.getRow();
        char destCol = destination.getCol();

        int rowDiff = abs(sourceRow - destRow);
        int colDiff = abs(sourceCol - destCol);

        if((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)){
            if(destination.getPeice() == null || destination.getPeice().getColor() != source.getPeice().getColor())
                return true;
        }

        return false;

    }

    private int abs(int num){
        return Math.abs(num);
    }
}
