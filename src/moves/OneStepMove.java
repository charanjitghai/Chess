package moves;
import main.Board;
import main.Square;
import peices.Peice;

public class OneStepMove implements Move{
	
	private static OneStepMove instance = null;
	private OneStepMove(){
	
	}

	public static OneStepMove getInstance(){
		if (instance == null)
			instance = new OneStepMove();
		return instance;
	}


	public boolean isValidMove(Square source, Square destination, Board board){
		int sourceRow = source.getRow() -1;
		int sourceCol = (int)source.getCol() - (int)'A';

		int destRow = destination.getRow() -1;
		int destCol = destination.getCol() - (int)'A';

		if(abs(sourceRow - destRow) >= 2 || abs(sourceCol - destCol) >= 2)
			return false;

		Peice destPeice = destination.getPeice();
		Peice sourcePeice = source.getPeice();

		if(destPeice != null && destPeice.getColor() == sourcePeice.getColor())
			return false;

		return true;

	}

	private int abs(int num){
		return Math.abs(num);
	}
}