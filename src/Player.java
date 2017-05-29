import java.util.ArrayList;
import java.util.Scanner;

public class Player{
	private Color color;
	private Board board;
	private Peice king;
	private ArrayList<Peice> rooks;
	private ArrayList<Peice> bishops;
	private void initKing(){
		
		OneStepMove oneStepMove = OneStepMove.getInstance();
		ArrayList<Move> allowedMoves = new ArrayList<Move>();
		allowedMoves.add(oneStepMove);
		
		Square location;
		if(color == Color.BLACK){
			location = board.getSquare(Constants.BLACK_KING_INIT_LOC);
			king = new Peice(Constants.BLACK_KING_ID, Constants.BLACK_KING_NAME, color, location, board, allowedMoves);
		}
		else{
			location = board.getSquare(Constants.WHITE_KING_INIT_LOC);
			king = new Peice(Constants.WHITE_KING_ID, Constants.WHITE_KING_NAME, color, location, board, allowedMoves);
		}


		
		location.setPeice(king);
	}


	private void initRooks(){

		VerticalMove vMove = VerticalMove.getInstance();
		HorizontalMove hMove = HorizontalMove.getInstance();
		ArrayList<Move> allowedMovesRook1 = new ArrayList<Move>();
		ArrayList<Move> allowedMovesRook2 = new ArrayList<Move>();
		allowedMovesRook1.add(vMove);
		allowedMovesRook1.add(hMove);
		allowedMovesRook2.add(vMove);
		allowedMovesRook2.add(hMove);
		Peice rook1, rook2;

		if(color == Color.BLACK){
			Square location1 = board.getSquare(Constants.BLACK_ROOK1_INIT_LOC);
			rook1 = new Peice(Constants.BLACK_ROOK1_ID, Constants.BLACK_ROOK1_NAME,
					color, location1, board, allowedMovesRook1);
			location1.setPeice(rook1);
			Square location2 = board.getSquare(Constants.BLACK_ROOK2_INIT_LOC);
			rook2 = new Peice(Constants.BLACK_ROOK2_ID, Constants.BLACK_ROOK2_NAME,
					color, location2, board, allowedMovesRook2);
			location2.setPeice(rook2);
		}
		else{
			Square location1 = board.getSquare(Constants.WHITE_ROOK1_INIT_LOC);
			rook1 = new Peice(Constants.WHITE_ROOK1_ID, Constants.WHITE_ROOK1_NAME,
					color, location1, board, allowedMovesRook1);
			location1.setPeice(rook1);
			Square location2 = board.getSquare(Constants.WHITE_ROOK2_INIT_LOC);
			rook2 = new Peice(Constants.WHITE_ROOK2_ID, Constants.WHITE_ROOK2_NAME,
					color, location2, board, allowedMovesRook2);
			location2.setPeice(rook2);

		}
		rooks = new ArrayList<Peice>();
		rooks.add(rook1);
		rooks.add(rook2);
	}

	private void initBishops(){
		DiagonalMove dMove = DiagonalMove.getInstance();

		ArrayList<Move> allowedMovesBishop1 = new ArrayList<Move>();
		ArrayList<Move> allowedMovesBishop2 = new ArrayList<Move>();

		allowedMovesBishop1.add(dMove);
		allowedMovesBishop2.add(dMove);

		Peice bishop1, bishop2;

		if(color == Color.BLACK){
			Square location1 = board.getSquare(Constants.BLACK_BISHOP1_INIT_LOC);
			bishop1 = new Peice(Constants.BLACK_BISHOP1_ID, Constants.BLACK_BISHOP1_NAME,
					color, location1, board, allowedMovesBishop1);
			location1.setPeice(bishop1);

			Square location2 = board.getSquare(Constants.BLACK_BIHOP2_INIT_LOC);
			bishop2 = new Peice(Constants.BLACK_BISHOP2_ID, Constants.BLACK_BISHOP2_NAME,
					color, location2, board, allowedMovesBishop2);
			location2.setPeice(bishop2);
		}
		else{
			Square location1 = board.getSquare(Constants.WHITE_BISHOP1_INIT_LOC);
			bishop1 = new Peice(Constants.WHITE_BISHOP1_ID, Constants.WHITE_BISHOP1_NAME,
					color, location1, board, allowedMovesBishop1);
			location1.setPeice(bishop1);

			Square location2 = board.getSquare(Constants.WHITE_BISHOP2_INIT_LOC);
			bishop2 = new Peice(Constants.WHITE_BISHOP2_ID, Constants.WHITE_BISHOP2_NAME,
					color, location2, board, allowedMovesBishop2);
			location2.setPeice(bishop2);
		}
		bishops = new ArrayList<Peice>();
		bishops.add(bishop1);
		bishops.add(bishop2);
	}


	public Player(Color color, Board board){
		this.color = color;
		this.board = board;
		initKing();
		initRooks();
		initBishops();
	}

	public boolean makeMove(){


		Scanner s = new Scanner(System.in);

		int source_row = s.nextInt();
		String source_col = s.next();


	
		int dest_row = s.nextInt();
		String dest_col = s.next();

		Square source = board.getSquare(source_col.charAt(0), source_row);
		Square destination = board.getSquare(dest_col.charAt(0), dest_row);


		if(source == null || source.getPeice() == null || (source.getPeice().getColor() != this.color))
			return false;

		Peice sourcePeice = source.getPeice();
		assert(sourcePeice != null);
		assert(sourcePeice.getColor() == this.color);

		return sourcePeice.move(destination);

	}

}