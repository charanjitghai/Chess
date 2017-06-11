package peices;

import java.util.HashMap;
import java.util.ArrayList;

import main.Board;
import main.Color;
import main.Constants;
import main.Square;

import moves.HorizontalMove;
import moves.Move;
import moves.VerticalMove;


/**
 * Created by cghai on 6/8/17.
 */
public class RookFactory{

    private static HashMap<PeiceFactoryKey, ArrayList<Peice>> rooksMap = new HashMap<PeiceFactoryKey, ArrayList<Peice>>();

    public static ArrayList<Peice> getRooks(Board board, Color color){

        PeiceFactoryKey key = new PeiceFactoryKey(board, color);
        ArrayList<Peice> rooks = rooksMap.get(key);

        if(rooks != null)
            return rooks;


        Peice rook1, rook2;

        if(color == Color.BLACK){
            Square location1 = board.getSquare(Constants.BLACK_ROOK1_INIT_LOC);
            rook1 = new Rook(Constants.BLACK_ROOK1_ID, Constants.BLACK_ROOK1_NAME,
                    color, location1, board);
            location1.setPeice(rook1);
            Square location2 = board.getSquare(Constants.BLACK_ROOK2_INIT_LOC);
            rook2 = new Rook(Constants.BLACK_ROOK2_ID, Constants.BLACK_ROOK2_NAME,
                    color, location2, board);
            location2.setPeice(rook2);
        }
        else{
            Square location1 = board.getSquare(Constants.WHITE_ROOK1_INIT_LOC);
            rook1 = new Rook(Constants.WHITE_ROOK1_ID, Constants.WHITE_ROOK1_NAME,
                    color, location1, board);
            location1.setPeice(rook1);
            Square location2 = board.getSquare(Constants.WHITE_ROOK2_INIT_LOC);
            rook2 = new Rook(Constants.WHITE_ROOK2_ID, Constants.WHITE_ROOK2_NAME,
                    color, location2, board);
            location2.setPeice(rook2);

        }
        rooks = new ArrayList<Peice>();
        rooks.add(rook1);
        rooks.add(rook2);

        rooksMap.put(key, rooks);

        return rooks;

    }

}
