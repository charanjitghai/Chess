public class Square{
	private final int row;
	private final char col;
	private final Color color;
	private boolean occupied;

	public Square(int row, char col, Color color, boolean occupied){
		this.row = row;
		this.col = col;
		this.color = color;
		this.occupied = occupied;
	}

	public Square(int row, char col, Color color){
		this(row, col, color, false);
	}

	public boolean isOccupied(){
		return this.occupied;
	}

	public void setOccupied(boolean occupied){
		this.occupied = occupied;
	}

	public Color getColor(){
		return this.color;
	}
}