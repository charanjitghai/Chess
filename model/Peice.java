import java.util.ArrayList;
public abstract class Peice{
	private String name;
	private Color color;
	private Square location;
	private ArrayList<Move> allowedMoves;
	private boolean alive;
	public Peice(String name, Color color, Square location, ArrayList<Move> allowedMoves){
		this.name = name;
		this.color = color;
		this.location = location;
		this.allowedMoves = allowedMoves;
		this.alive = true;
	}

	public void kill(){
		this.alive = false;
		this.location.setPeice(null);
	}

	public boolean isValidMove(Square destination){
		for(Move move: allowedMoves){
			if(move.isValidMove(this.location, destination)){
				return true;
			}
		}
		return false;
	}

	public boolean move(Square destination){
		if(isValidMove(destination)){
			this.location = destination;
			return true;
		}
		return false;
	}
}