package peices;

import java.util.ArrayList;
import java.util.HashMap;
import main.Board;
import main.Color;
import main.Square;

/**
 * Created by cghai on 6/19/17.
 */
public class PawnFactory {

    private static HashMap<PeiceFactoryKey, ArrayList<Peice>> pawnsMap = new HashMap<PeiceFactoryKey, ArrayList<Peice>>();

    public static ArrayList<Peice> getPawns(Board board, Color color){

        PeiceFactoryKey key = new PeiceFactoryKey(board, color);
        ArrayList<Peice> pawns = pawnsMap.get(key);

        if(pawns != null)
            return pawns;

        pawns = new ArrayList<Peice>();

        if(color == Color.BLACK){
            for(int i = 1; i<=8; i++) {
                Square location = board.getSquare((char)('A' - 1 + i),7);
                Pawn pawn = new Pawn("BP" + i, "BP", color, location, board);
                location.setPeice(pawn);
                pawns.add(pawn);
            }
        }
        else{
            for(int i = 1; i<=8; i++) {
                Square location = board.getSquare((char)('A' - 1 + i), 2);
                Pawn pawn = new Pawn("WP" + i, "WP", color, location, board);
                location.setPeice(pawn);
                pawns.add(pawn);
            }
        }

        pawnsMap.put(key, pawns);
        return pawns;
    }

}
