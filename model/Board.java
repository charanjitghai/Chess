import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

import java.lang.Character;

public class Board{

	private Map<String,Square> positionToSquare;
	public static final char [] cols = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
	public static final int [] rows = {1, 2, 3, 4, 5, 6, 7, 8};

	public Board(){

		positionToSquare = new HashMap<String, Square>();

	 	

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

	public Square getSquare(String position){
		return positionToSquare.get(position);
	}

	public Square getSquare(char col, int row){
		String position = String.valueOf(col) + String.valueOf(row);
		return positionToSquare.get(position);
	}

	public void printBoard(){

		System.out.print(" ");
		for(char col: cols){
			System.out.print(String.format("%4s", Character.toString(col) + Character.toString(Character.toLowerCase(col))));
		}

		System.out.println("");
		
		for(int i = rows.length -1; i>=0 ; i--){

			int row = rows[i];
			System.out.print(row);

			for(char col: cols){
					
				Square square = getSquare(col, row);
				Peice peice = square.getPeice();
				if(peice != null)
					System.out.print(String.format("%4s", peice.getName()));
				else
					System.out.print(String.format("%4s", ".."));

			}
			System.out.println("");
		}
	}

	public static void main(String args[]){
		while(true){
			Scanner s = new Scanner(System.in);
			Board b = new Board();
			Square sq = b.getSquare(s.nextLine().charAt(0) , s.nextInt());
			System.out.println(sq.getColor().toString());
		}
	}

}