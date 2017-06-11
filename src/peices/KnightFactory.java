package peices;

import main.Board;
import main.Color;
import main.Square;

import moves.KnightMove;
import moves.Move;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cghai on 6/8/17.
 */
public class KnightFactory{

    private static HashMap<PeiceFactoryKey, ArrayList<Peice>> knightsMap = new HashMap<PeiceFactoryKey, ArrayList<Peice>>();

    public static ArrayList<Peice> getKnights(Board board, Color color){

        PeiceFactoryKey key = new PeiceFactoryKey(board, color);
        ArrayList<Peice> knights = knightsMap.get(key);

        if(knights != null)
            return knights;


        Peice knight1, knight2;

        if(color == Color.BLACK){
            Square location1 = board.getSquare(Constants.BLACK_KNIGHT1_INIT_LOC);
            knight1 = new Knight(Constants.BLACK_KNIGHT1_ID, Constants.BLACK_KNIGHT1_NAME,
                    color, location1, board);
            location1.setPeice(knight1);

            Square location2 = board.getSquare(Constants.BLACK_KNIGHT2_INIT_LOC);
            knight2 = new Knight(Constants.BLACK_KNIGHT2_ID, Constants.BLACK_KNIGHT2_NAME,
                    color, location2, board);
            location2.setPeice(knight2);
        }
        else{
            Square location1 = board.getSquare(Constants.WHITE_KNIGHT1_INIT_LOC);
            knight1  = new Knight(Constants.WHITE_KNIGHT1_ID, Constants.WHITE_KNIGHT1_NAME,
                    color, location1, board);
            location1.setPeice(knight1);

            Square location2 = board.getSquare(Constants.WHITE_KNIGHT2_INIT_LOC);
            knight2 = new Knight(Constants.WHITE_KNIGHT2_ID, Constants.WHITE_KNIGHT2_NAME,
                    color, location2, board);
            location2.setPeice(knight2);
        }

        knights = new ArrayList<Peice>();
        knights.add(knight1);
        knights.add(knight2);

        knightsMap.put(key, knights);

        return knights;
    }

}
