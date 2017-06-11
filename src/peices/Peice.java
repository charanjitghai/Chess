package peices;
import java.util.ArrayList;

import moves.*;
import main.Color;
import main.Square;
import main.Board;

public class Peice{

	private String id;
	private String name;
	private Color color;
	private Square location;
	private Board board;
	private ArrayList<Move> allowedMoves;
	private boolean alive;

	public Peice(String id, String name, Color color, Square location, Board board, ArrayList<Move> allowedMoves){
		this.id = id;
		this.name = name;
		this.color = color;
		this.location = location;
		this.board = board;
		this.allowedMoves = allowedMoves;
		this.alive = true;
	}

	protected void addMove(Move move){
	    this.allowedMoves.add(move);
    }

	public void kill(){
		this.alive = false;
		this.location.setPeice(null);
	}

	public boolean isValidMove(Square destination){
		for(Move move: allowedMoves){
			if(move.isValidMove(this.location, destination, board)){
				return true;
			}
		}
		return false;
	}

	public boolean move(Square destination){
		if(isValidMove(destination)){
			Peice destinationPeice = destination.getPeice();
			if(destinationPeice != null)
				destinationPeice.kill();
			this.location.setPeice(null);
			this.location = destination;
			this.location.setPeice(this);
			return true;
		}
		return false;
	}

	public String getName(){
		return this.name;
	}

	public Color getColor(){
		return color;
	}
}