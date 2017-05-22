public class Chess{

	private Player whitePlayer;
	private Player blackPlayer;
	private Player currentPlayer;

	private State state;

	private Board board;

	public Chess(){
		whitePlayer = new Player(Color.WHITE);
		blackPlayer = new Player(Color.BLACK);
		board = new Board();
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
			chess.currentPlayer.makeMove();
			chess.togglePlayer();
			chess.state = chess.refreshState();
		}

	}

	private State refreshState(){
		return State.RUNNING;
	}

}