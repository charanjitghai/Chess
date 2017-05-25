public class Chess{

	private Player whitePlayer;
	private Player blackPlayer;
	private Player currentPlayer;

	private State state;

	private Board board;

	public Chess(){
		board = new Board();
		whitePlayer = new Player(Color.WHITE, board);
		blackPlayer = new Player(Color.BLACK, board);
		state = State.RUNNING;
		currentPlayer = whitePlayer;
	}

	private void togglePlayer(){
		if(currentPlayer == whitePlayer)
			currentPlayer = blackPlayer;
		else
			currentPlayer = whitePlayer;
	}

	public static void main(String args[]){

		Chess chess = new Chess();

		while(chess.state != State.END){
			chess.board.printBoard();
			if(chess.currentPlayer.makeMove()){
				chess.togglePlayer();
				chess.state = chess.refreshState();
			}
		}

	}

	private State refreshState(){
		return State.RUNNING;
	}

}