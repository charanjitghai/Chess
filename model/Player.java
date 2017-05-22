public class Player{
	private Color color;

	public Player(Color color){
		this.color = color;
	}

	public void makeMove(){
		System.out.println(this.color.toString() + "'s move");
	}

}