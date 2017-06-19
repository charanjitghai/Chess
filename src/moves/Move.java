package moves;
import main.Square;
import main.Board;

public interface Move{
	public boolean isValidMove(final Square source, final Square destination, final Board board);
}