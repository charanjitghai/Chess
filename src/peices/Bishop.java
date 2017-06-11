package peices;

import main.Board;
import main.Color;
import main.Square;
import moves.DiagonalMove;
import moves.Move;

import java.util.ArrayList;

/**
 * Created by cghai on 6/10/17.
 */
class Bishop extends Peice {
    Bishop(String id, String name, Color color, Square location, Board board){
        super(id, name, color, location, board, new ArrayList<Move>());
        addMove(DiagonalMove.getInstance());
    }
}
