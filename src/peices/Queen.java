package peices;

import main.Board;
import main.Color;
import main.Square;
import moves.DiagonalMove;
import moves.HorizontalMove;
import moves.Move;
import moves.VerticalMove;

import java.util.ArrayList;

/**
 * Created by cghai on 6/10/17.
 */
class Queen extends Peice{
    Queen(String id, String name, Color color, Square location, Board board){
        super(id, name, color, location, board, new ArrayList<Move>());
        addMove(DiagonalMove.getInstance());
        addMove(HorizontalMove.getInstance());
        addMove(VerticalMove.getInstance());
    }
}
