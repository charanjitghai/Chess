public class HorizontalMove implements Move{
	
	private static HorizontalMove instance = null;
	private HorizontalMove(){
	
	}
	
	public static HorizontalMove getInstance(){
		if(instance == null)
			instance = new HorizontalMove;
		return instance;
	}
	
	public boolean isValidMove(Square source, Square destination){
		
		int sourceRow = source.getRow();
		int sourceCol = (int) source.getCol() - (int)'A';

		int destRow = destination.getRow();
		int destCol = destination.getCol() - (int)'A';

		if(destRow != sourceRow)
			return false;
		
		return true;
	
	}

}
