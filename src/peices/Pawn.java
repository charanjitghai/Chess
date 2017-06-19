package peices;

import main.Board;
import main.Color;
import main.Square;
import moves.Move;
import moves.OneStepDiagonalKillMove;
import moves.OneStepForwardMove;

import java.util.ArrayList;

/**
 * Created by cghai on 6/18/17.
 */
class Pawn extends Peice {

    Pawn(String id, String name, Color color, Square location, Board board){
        super(id, name, color, location, board, new ArrayList<Move>());
        addMove(OneStepForwardMove.getInstance());
        addMove(OneStepDiagonalKillMove.getInstance());
    }
}
