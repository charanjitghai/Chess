import java.util.ArrayList;
import java.util.Scanner;

public class Player{
	private Color color;
	private Board board;
	Peice King;

	private void initKing(){
		
		OneStepMove oneStepMove = OneStepMove.getInstance();
		ArrayList<Move> allowedMoves = new ArrayList<Move>();
		allowedMoves.add(oneStepMove);
		
		Square location;
		if(color == Color.BLACK){
			location = board.getSquare(Constants.BLACK_KING_INIT_LOC);
			King = new Peice(Constants.BLACK_KING_ID, Constants.BLACK_KING_NAME, color, location, board, allowedMoves);
		}
		else{
			location = board.getSquare(Constants.WHITE_KING_INIT_LOC);
			King = new Peice(Constants.WHITE_KING_ID, Constants.WHITE_KING_NAME, color, location, board, allowedMoves);
		}


		
		location.setPeice(King);
	}

	public Player(Color color, Board board){
		this.color = color;
		this.board = board;
		initKing();

	}

	public boolean makeMove(){


		Scanner s = new Scanner(System.in);

		int source_row = s.nextInt();
		String source_col = s.next();


	
		int dest_row = s.nextInt();
		String dest_col = s.next();

		Square source = board.getSquare(source_col.charAt(0), source_row);
		Square destination = board.getSquare(dest_col.charAt(0), dest_row);


		if(source == null){
			System.out.println("Bug");
		}
		Peice sourcePeice = source.getPeice();
		assert(sourcePeice != null);
		assert(sourcePeice.getColor() == this.color);

		return sourcePeice.move(destination);

	}

}