package main;

import java.util.ArrayList;

import peices.*;

/**
 * Created by cghai on 6/10/17.
 */
public class PeiceSet {
    private Peice king;
    private Peice queen;
    private ArrayList<Peice> bishops;
    private ArrayList<Peice> knights;
    private ArrayList<Peice> rooks;
    private Board board;
    private Color color;
    private ArrayList<Peice> allPeices;

    PeiceSet(Board board, Color color){
        king = KingFactory.getKing(board, color);
        queen = QueenFactory.getQueen(board, color);
        bishops = BishopFactory.getBishops(board, color);
        knights = KnightFactory.getKnights(board, color);
        rooks = RookFactory.getRooks(board, color);
        this.board = board;
        this.color = color;

        allPeices = new ArrayList<Peice>();
        allPeices.add(king);
        allPeices.add(queen);
        allPeices.addAll(bishops);
        allPeices.addAll(knights);
        allPeices.addAll(rooks);
    }

    public ArrayList<Peice> getAllPeices(){
        return allPeices;
    }

    public ArrayList<Peice> getAlivePeices(){
        return allPeices;
    }
}
