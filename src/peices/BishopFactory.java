package peices;

import main.Board;
import main.Color;
import main.Constants;
import main.Square;
import moves.DiagonalMove;
import moves.Move;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cghai on 6/8/17.
 */
public class BishopFactory{

    private static HashMap<PeiceFactoryKey, ArrayList<Peice>> bishopsMap = new HashMap<PeiceFactoryKey, ArrayList<Peice>>();

    public static ArrayList<Peice> getBishops(Board board, Color color){

        PeiceFactoryKey key = new PeiceFactoryKey(board, color);
        ArrayList<Peice> bishops = bishopsMap.get(key);
        if(bishops != null)
            return bishops;


        Peice bishop1, bishop2;

        if(color == Color.BLACK){
            Square location1 = board.getSquare(Constants.BLACK_BISHOP1_INIT_LOC);
            bishop1 = new Bishop(Constants.BLACK_BISHOP1_ID, Constants.BLACK_BISHOP1_NAME,
                    color, location1, board);
            location1.setPeice(bishop1);

            Square location2 = board.getSquare(Constants.BLACK_BIHOP2_INIT_LOC);
            bishop2 = new Bishop(Constants.BLACK_BISHOP2_ID, Constants.BLACK_BISHOP2_NAME,
                    color, location2, board);
            location2.setPeice(bishop2);
        }
        else{
            Square location1 = board.getSquare(Constants.WHITE_BISHOP1_INIT_LOC);
            bishop1 = new Bishop(Constants.WHITE_BISHOP1_ID, Constants.WHITE_BISHOP1_NAME,
                    color, location1, board);
            location1.setPeice(bishop1);

            Square location2 = board.getSquare(Constants.WHITE_BISHOP2_INIT_LOC);
            bishop2 = new Bishop(Constants.WHITE_BISHOP2_ID, Constants.WHITE_BISHOP2_NAME,
                    color, location2, board);
            location2.setPeice(bishop2);
        }

        bishops = new ArrayList<Peice>();
        bishops.add(bishop1);
        bishops.add(bishop2);

        bishopsMap.put(key, bishops);

        return bishops;
    }
}
