package peices;


/**
 * Created by cghai on 6/10/17.
 */

import main.Board;
import main.Color;

class PeiceFactoryKey {
    private Board board;
    private Color color;


    public PeiceFactoryKey(Board board, Color color){
        this.board = board;
        this.color = color;
    }

    public Board getBoard(){
        return board;
    }

    public Color getColor(){
        return color;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof PeiceFactoryKey){
            if(((PeiceFactoryKey) other).getBoard() == board  && ((PeiceFactoryKey) other).getColor() == color)
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return board.hashCode() * color.hashCode();
    }
}
