public class Square{
	private final int row;
	private final char col;
	private final Color color;
	private Peice peice;

	public Square(int row, char col, Color color, Peice peice){
		this.row = row;
		this.col = col;
		this.color = color;
		this.peice = peice;
	}

	public Square(int row, char col, Color color){
		this(row, col, color, null);
	}

	public boolean isOccupied(){
		return this.peice == null;
	}

	public void setPeice(Peice peice){
		this.peice = peice;
	}

	public Color getColor(){
		return this.color;
	}
}