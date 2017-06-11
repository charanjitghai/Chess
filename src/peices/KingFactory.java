package peices;

import java.util.HashMap;

import main.Board;
import main.Color;
import main.Constants;
import main.Square;
import moves.Move;
import moves.OneStepMove;

import java.util.ArrayList;

/**
 * Created by cghai on 6/8/17.
 */
public class KingFactory{

    private static HashMap<PeiceFactoryKey, Peice> kingMap = new HashMap<PeiceFactoryKey, Peice>();


    public static Peice getKing(Board board, Color color){

        PeiceFactoryKey key = new PeiceFactoryKey(board, color);
        Peice king = kingMap.get(key);
        if(king != null)
            return king;

        Square location;
        if(color == Color.BLACK){
            location = board.getSquare(Constants.BLACK_KING_INIT_LOC);
            king = new King(Constants.BLACK_KING_ID, Constants.BLACK_KING_NAME,
                    color, location, board);
        }
        else{
            location = board.getSquare(Constants.WHITE_KING_INIT_LOC);
            king = new King(Constants.WHITE_KING_ID, Constants.WHITE_KING_NAME,
                    color, location, board);
        }

        location.setPeice(king);

        kingMap.put(key, king);

        return king;
    }


}
