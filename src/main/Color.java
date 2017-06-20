package main;

public enum Color{
	WHITE, BLACK;

	public Color toggle(){
		if(this.equals(Color.WHITE))
			return Color.BLACK;
		else
			return Color.WHITE;
	}

	public String toString(){
		if (this.equals(Color.WHITE))
			return "WHITE";
		else
			return "BLACK";
	}

}