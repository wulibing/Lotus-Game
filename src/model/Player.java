package model;

import java.awt.Color;
import model.Board;

public class Player {
	
	private Board _board;

	private Color _color;
	private int _score;
	
	/**
	 * @param c assigns the colors to each player. 
	 */
	public Player(Color c) {
		_color = c;
		_score = 0;
//		String s = leftTrack()[14].toString();
//		for(int i=0;i<s.length();i++){
//			char c = s.charAt(i);
//			switch(c){
//			case'R':{_red++;break;}
//			case'B':{_blue++;break;}
//			case'G':{_green++;break;}
//			case'W':{_white++;break;}
//			case'K':{_black++;break;} 
//			case'Y':{_yellow++;break;}}}
//		
//			if(_playersNumber<=3){
//				if(_red==10){_board.win("Red");}
//				if(_blue==10){_board.win("Blue");}
//				if(_green==10){_board.win("Green");}
//				if(_white==10){_board.win("White");}
//				if(_black==10){_board.win("Black");}
//				if(_yellow==10){_board.win("Yellow");}
//			}
//			if(_playersNumber>=4){
//				if(_red==6){_board.win("Red");}
//				if(_blue==6){_board.win("Blue");}
//				if(_green==6){_board.win("Green");}
//				if(_white==6){_board.win("White");}
//				if(_black==6){_board.win("Black");}
//				if(_yellow==6){_board.win("Yellow");}
//			}
	}

}
