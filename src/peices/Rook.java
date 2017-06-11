package peices;

import main.Board;
import main.Color;
import main.Square;
import moves.HorizontalMove;
import moves.Move;
import moves.VerticalMove;

import java.util.ArrayList;

/**
 * Created by cghai on 6/10/17.
 */
class Rook extends Peice {
    Rook(String id, String name, Color color, Square location, Board board){
        super(id, name, color, location, board, new ArrayList<Move>());
        addMove(VerticalMove.getInstance());
        addMove(HorizontalMove.getInstance());
    }
}
