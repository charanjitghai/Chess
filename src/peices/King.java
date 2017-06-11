package peices;

import main.Board;
import main.Color;
import main.Square;
import moves.Move;
import moves.OneStepMove;

import java.util.ArrayList;

/**
 * Created by cghai on 6/10/17.
 */
class King extends Peice {

    King(String id, String name, Color color, Square location, Board board){
        super(id, name, color, location, board, new ArrayList<Move>());
        addMove(OneStepMove.getInstance());
    }
}
