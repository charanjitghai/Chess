package moves;
import main.Square;
import main.Board;

public interface Move{
	public boolean isValidMove(Square source, Square destination, Board board);
}