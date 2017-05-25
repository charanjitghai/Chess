import java.util.ArrayList;
public class Peice{
	private String id;
	private String name;
	private Color color;
	private Square location;
	private ArrayList<Move> allowedMoves;
	private boolean alive;
	public Peice(String id, String name, Color color, Square location, ArrayList<Move> allowedMoves){
		this.id = id;
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