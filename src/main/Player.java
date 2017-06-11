package main;

import java.util.ArrayList;
import java.util.Scanner;
import peices.Peice;
import moves.*;

public class Player{
	private Color color;
	private Board board;


	public Player(Color color, Board board){
		this.color = color;
		this.board = board;
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