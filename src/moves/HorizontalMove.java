package moves;
import main.Square;
import main.Board;

public class HorizontalMove implements Move{
	
	private static HorizontalMove instance = null;
	private HorizontalMove(){
	
	}
	
	public static HorizontalMove getInstance(){
		if(instance == null)
			instance = new HorizontalMove();
		return instance;
	}
	
	public boolean isValidMove(Square source, Square destination, Board board){
		
		int sourceRow = source.getRow();
		char sourceCol = source.getCol();

		int destRow = destination.getRow();
		char destCol = destination.getCol();

		if(sourceRow != destRow)
			return false;

		int step;
		if(sourceCol < destCol)
			step = 1;
		else if(sourceCol > destCol)
			step = -1;
		else
			return false;

		for(char col = (char) (sourceCol + step); col != destCol; col += step){
			Square square = board.getSquare(col, sourceRow);
			if(square.getPeice() != null)
				return false;
		}


		return true;
	
	}

}
