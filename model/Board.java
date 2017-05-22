import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Board{

	private Map<String,Square> positionToSquare;

	public Board(){

		positionToSquare = new HashMap<String, Square>();

	 	char [] cols = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		int [] rows = {1, 2, 3, 4, 5, 6, 7, 8};


		for(int i = 0; i<rows.length; i++){

			int row = rows[i];

			Color color;
			if(row%2 == 1)
				color = Color.BLACK;
			else
				color = Color.WHITE;


			for(int j = 0; j<cols.length; j++){
				
				char col = cols[j];
				Square square = new Square(row, col, color);
				
				String position = String.valueOf(col) + String.valueOf(row);
				positionToSquare.put(position, square);

				color = color.toggle();
				
			}
		}
	}

	public Square get(String position){
		return positionToSquare.get(position);
	}

	public static void main(String args[]){
		while(true){
			Scanner s = new Scanner(System.in);
			Board b = new Board();
			Square sq = b.get(s.nextLine() + String.valueOf(s.nextInt()));
			System.out.println(sq.getColor().toString());
		}
	}

}