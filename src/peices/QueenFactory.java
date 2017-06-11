package peices;

import java.util.HashMap;

import main.Board;
import main.Color;
import main.Square;
import moves.Move;
import moves.HorizontalMove;
import moves.VerticalMove;
import moves.DiagonalMove;

import java.util.ArrayList;

/**
 * Created by cghai on 6/8/17.
 */
public class QueenFactory{

    private static HashMap<PeiceFactoryKey, Peice> queenMap = new HashMap<PeiceFactoryKey, Peice>();

    public static Peice getQueen(Board board, Color color){

        PeiceFactoryKey key = new PeiceFactoryKey(board, color);
        Peice queen = queenMap.get(key);

        if(queen != null)
            return queen;

        Square location;
        if(color == Color.BLACK){
            location = board.getSquare(Constants.BLACK_QUEEN_INIT_LOC);
            queen = new Queen(Constants.BLACK_QUEEN_ID, Constants.BLACK_QUEEN_NAME,
                    color, location, board);
        }
        else{
            location = board.getSquare(Constants.WHITE_QUEEN_INIT_LOC);
            queen = new Queen(Constants.WHITE_QUEEN_ID, Constants.WHITE_QUEEN_NAME,
                    color, location, board);
        }

        location.setPeice(queen);

        queenMap.put(key, queen);

        return queen;

    }

}
