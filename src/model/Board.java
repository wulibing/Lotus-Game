package model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ui.Game;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;



public class Board {
	
	private ActionListener _listener;
	
	private Position[] _left;
	private Position[] _center;
	private Position[] _right;
//	private Position[] _common;
//	private StartPosition[] _redStart;
//	private StartPosition[] _blueStart;
//	private StartPosition[] _greenStart;
//	private StartPosition[] _whiteStart;
//	private StartPosition[] _blackStart;
//	private StartPosition[] _yellowStart;
	private int _red=0;
	private int _blue=0;
	private int _green=0;
	private int _white=0;
	private int _black=0;
	private int _yellow=0;
	public JFrame _window;
	
	private Finch _finch;
	
	

	private StartPosition[][] _start;
	private int _startNumber;
	private int _playersNumber;
	
	private Game _game;
	

	/**
	 * designates the actionListener _listener as al
	 */

	public void setActionListener(ActionListener al) {
		_listener = al;
	}
	/**
	 * if the actionListener isnt equal to null, notifyOfChange makes actionPerformed
	 * null
	 */
	public void notifyOfChange() {
		if (_listener != null) {
			_listener.actionPerformed(null);
		}
	}
	
	
	/**
	 * method Board creates the board 
	 * @param playersNumber
	 * @param g
	 */
	public Board(int playersNumber, Game g) {
		_game=g;
		_playersNumber=playersNumber;
		_left = new Position[15];
		_center = new Position[15];
		_right = new Position[15];
		String[] players = {"R","B","G","W","K","Y"};
		
		if(_game._controllerFinch){

			JFrame frame=new JFrame();
			JButton button = new JButton("connect");
			frame.add(button);
			button.addActionListener(new FinchListener(this, _finch));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);		
			
			_finch=new Finch();
		}
		
		if(_game._playersNumber<=3){
			_startNumber=4;
		}else{_startNumber=3;}
		
		for (int i=0; i<3; i++) {
			_left[i] = (new Position(0,i,this));
			_center[i] = (new Position(0,i,this));
			_right[i] = (new Position(0,i,this));
		}
		for (int i=3; i<15; i++) {
			_left[i] = (new Position(0,i,this));
			_right[i] = _left[i];
			_center[i] = _left[i];
		}
		_start = new StartPosition[_game._playersNumber][4];	

		for (int i = 0; i < _game._playersNumber; i++){
			for(int j = 0; j < _startNumber; j++){
					_start[i][j] = new StartPosition(0,i,this);
					populate(_start[i][j], players[i], j+1);
			}

		}	
//		_redStart = new StartPosition[4];
//		_blueStart = new StartPosition[4];
//		_greenStart = new StartPosition[4];
//		_whiteStart = new StartPosition[4];
//		_blackStart = new StartPosition[4];
//		_yellowStart = new StartPosition[4];
//		if(_game._playersNumber==2){
//			for (int i=0; i<4; i++) {
//				_redStart[i] = (new StartPosition(0,i,this));
//				populate(_redStart[i], "R", i+1);
//				_blueStart[i] = (new StartPosition(0,i,this));
//				populate(_blueStart[i], "B", i+1);
//			}
//		}
//		if(_game._playersNumber==3){
//			for (int i=0; i<4; i++) {
//				_redStart[i] = (new StartPosition(0,i,this));
//				populate(_redStart[i], "R", i+1);
//				_blueStart[i] = (new StartPosition(0,i,this));
//				populate(_blueStart[i], "B", i+1);
//				_greenStart[i] = (new StartPosition(0,i,this));
//				populate(_greenStart[i], "G", i+1);
//			}
//		}	
//		if(_game._playersNumber==4){
//			for (int i=0; i<3; i++) {
//				_redStart[i] = (new StartPosition(0,i,this));
//				populate(_redStart[i], "R", i+1);
//				_blueStart[i] = (new StartPosition(0,i,this));
//				populate(_blueStart[i], "B", i+1);
//				_greenStart[i] = (new StartPosition(0,i,this));
//				populate(_greenStart[i], "G", i+1);
//				_whiteStart[i] = (new StartPosition(0,i,this));
//				populate(_whiteStart[i], "W", i+1);
//			}
//		}	
//		if(_game._playersNumber==5){
//			for (int i=0; i<3; i++) {
//				_redStart[i] = (new StartPosition(0,i,this));
//				populate(_redStart[i], "R", i+1);
//				_blueStart[i] = (new StartPosition(0,i,this));
//				populate(_blueStart[i], "B", i+1);
//				_greenStart[i] = (new StartPosition(0,i,this));
//				populate(_greenStart[i], "G", i+1);
//				_whiteStart[i] = (new StartPosition(0,i,this));
//				populate(_whiteStart[i], "W", i+1);
//				_blackStart[i] = (new StartPosition(0,i,this));
//				populate(_blackStart[i], "K", i+1);
//			}
//		}	
//		if(_game._playersNumber==6){
//			for (int i=0; i<3; i++) {
//				_redStart[i] = (new StartPosition(0,i,this));
//				populate(_redStart[i], "R", i+1);
//				_blueStart[i] = (new StartPosition(0,i,this));
//				populate(_blueStart[i], "B", i+1);
//				_greenStart[i] = (new StartPosition(0,i,this));
//				populate(_greenStart[i], "G", i+1);
//				_whiteStart[i] = (new StartPosition(0,i,this));
//				populate(_whiteStart[i], "W", i+1);
//				_blackStart[i] = (new StartPosition(0,i,this));
//				populate(_blackStart[i], "K", i+1);
//				_yellowStart[i] = (new StartPosition(0,i,this));
//				populate(_yellowStart[i], "Y", i+1);
//			}
//		}
//		for (int i=0; i<4; i++) {
//			_redStart[i] = (new StartPosition(0,i,this));
//			populate(_redStart[i], "R", i+1);
//			_blueStart[i] = (new StartPosition(0,i,this));
//			populate(_blueStart[i], "B", i+1);
//			_greenStart[i] = (new StartPosition(0,i,this));
//			populate(_greenStart[i], "G", i+1);
//			_whiteStart[i] = (new StartPosition(0,i,this));
//			populate(_whiteStart[i], "W", i+1);
//			_blackStart[i] = (new StartPosition(0,i,this));
//			populate(_blackStart[i], "K", i+1);
//			_yellowStart[i] = (new StartPosition(0,i,this));
//			populate(_yellowStart[i], "Y", i+1);
//		}
	}

	private void populate(Position pos, String s, int howMany) {
		for (int i=0; i<howMany; i++) {
			pos.putOn(new Piece(pos,s));
		}
	}

	/**
	 * method getBoard implements the ArrayList and creates a temp ArrayList
	 * @return <String>
	 */
	public ArrayList<String> getBoard() {
		ArrayList<String> temp = new ArrayList<String>();
		

		
		for(int i=0;i<_game._playersNumber;i++){
			for(int j=0;j<_startNumber;j++){
				temp.add(_start[i][j].toString());
			}
			
		}
//		for (int i=0; i<4; i++) {
//			temp.add(_redStart[i].toString());
//			temp.add(_blueStart[i].toString());
//			temp.add(_greenStart[i].toString());
//			temp.add(_whiteStart[i].toString());
//			temp.add(_blackStart[i].toString());
//			temp.add(_yellowStart[i].toString());
//		}
//		if(_game._playersNumber==2){
//		for (int i=0; i<4; i++) {
//			temp.add(_redStart[i].toString());
//			temp.add(_blueStart[i].toString());
//		}
//	}
//	if(_game._playersNumber==3){
//		for (int i=0; i<4; i++) {
//			temp.add(_redStart[i].toString());
//			temp.add(_blueStart[i].toString());
//			temp.add(_greenStart[i].toString());
//		}	
//	}
//	if(_game._playersNumber==4){
//		for (int i=0; i<3; i++) {
//			temp.add(_redStart[i].toString());
//			temp.add(_blueStart[i].toString());
//			temp.add(_greenStart[i].toString());
//			temp.add(_whiteStart[i].toString());
//		}	
//	}
//	if(_game._playersNumber==5){
//		for (int i=0; i<3; i++) {
//			temp.add(_redStart[i].toString());
//			temp.add(_blueStart[i].toString());
//			temp.add(_greenStart[i].toString());
//			temp.add(_whiteStart[i].toString());
//			temp.add(_blackStart[i].toString());
//		}	
//	}
//	if(_game._playersNumber==6){
//		for (int i=0; i<3; i++) {
//			temp.add(_redStart[i].toString());
//			temp.add(_blueStart[i].toString());
//			temp.add(_greenStart[i].toString());
//			temp.add(_whiteStart[i].toString());
//			temp.add(_blackStart[i].toString());
//			temp.add(_yellowStart[i].toString());
//		}
//	}
		for (int i=0; i<3; i++) {
			int centerOffset=getCenter(i).getOffset();
			int leftOffset=getLeft(i).getOffset();
			int rightOffset=getRight(i).getOffset();
			if(leftOffset>0){
				temp.add(_left[i].toString()+"+"+(leftOffset));
				temp.add(_center[i].toString());
				temp.add(_right[i].toString());
			}else if(centerOffset>0){
				temp.add(_left[i].toString());
				temp.add(_center[i].toString()+"+"+(centerOffset));
				temp.add(_right[i].toString());
			}else if(rightOffset>0){
				temp.add(_left[i].toString());
				temp.add(_center[i].toString());
				temp.add(_right[i].toString()+"+"+(rightOffset));
			}else if(getLeft(i).checkBack()){
				temp.add(_left[i].toString()+"<<");
				temp.add(_center[i].toString());
				temp.add(_right[i].toString());
			}else if(getCenter(i).checkBack()){
				temp.add(_left[i].toString());
				temp.add(_center[i].toString()+"<<");
				temp.add(_right[i].toString());
			}else if(getRight(i).checkBack()){
				temp.add(_left[i].toString());
				temp.add(_center[i].toString());
				temp.add(_right[i].toString()+"<<");
			}else{
				temp.add(_left[i].toString());
				temp.add(_center[i].toString());
				temp.add(_right[i].toString());
			}

		}
		for (int i=3; i<14; i++) {
			int offset=getCommon(i).getOffset();
			boolean checkBack=getCommon(i).checkBack();
			
			if(offset>0){
				temp.add(_right[i].toString()+"+"+(offset));
			}
			else if (checkBack){
				temp.add(_right[i].toString()+"<<");
			}
			else{temp.add(_right[i].toString());}		
//			temp.add(_common[i].toString());
		}
		return temp;
	}

	
//	if(_game._playersNumber==2){
//	for (int i=0; i<4; i++) {
//		temp.add(_redStart[i].toString());
//		temp.add(_blueStart[i].toString());
//	}
//}
//if(_game._playersNumber==3){
//	for (int i=0; i<4; i++) {
//		temp.add(_redStart[i].toString());
//		temp.add(_blueStart[i].toString());
//		temp.add(_greenStart[i].toString());
//	}	
//}
//if(_game._playersNumber==4){
//	for (int i=0; i<3; i++) {
//		temp.add(_redStart[i].toString());
//		temp.add(_blueStart[i].toString());
//		temp.add(_greenStart[i].toString());
//		temp.add(_whiteStart[i].toString());
//	}	
//}
//if(_game._playersNumber==5){
//	for (int i=0; i<3; i++) {
//		temp.add(_redStart[i].toString());
//		temp.add(_blueStart[i].toString());
//		temp.add(_greenStart[i].toString());
//		temp.add(_whiteStart[i].toString());
//		temp.add(_blackStart[i].toString());
//	}	
//}
//if(_game._playersNumber==6){
//	for (int i=0; i<3; i++) {
//		temp.add(_redStart[i].toString());
//		temp.add(_blueStart[i].toString());
//		temp.add(_greenStart[i].toString());
//		temp.add(_whiteStart[i].toString());
//		temp.add(_blackStart[i].toString());
//		temp.add(_yellowStart[i].toString());
//	}	


//	public StartPosition getRedStart(int i) { return _redStart[i]; }
//	public StartPosition getBlueStart(int i) { return _blueStart[i]; }
//	public StartPosition getGreenStart(int i) { return _greenStart[i]; }
//	public StartPosition getWhiteStart(int i) { return _whiteStart[i]; }
//	public StartPosition getBlackStart(int i) { return _blackStart[i]; }
//	public StartPosition getYellowStart(int i) { return _yellowStart[i]; }
	public StartPosition getStart(int i, int j) {
		// TODO Auto-generated method stub
		return _start[i][j];
	}
	public Position getLeft(int i) { return _left[i]; }
	public Position getCenter(int i) { return _center[i]; }
	public Position getRight(int i) { return _right[i]; }
	public Position getCommon(int i) { return _right[i]; }
//	public Position getCommon(int i) { return _common[i]; }

	/**
	 * method leftTrack sets the left track (top path) of the board
	 * @return left position
	 */
	public Position[] leftTrack() {
		return _left;
	}
/**
 * method rightTrack sets the right track (bottom path) of the board
 * @return right position
 */
	public Position[] rightTrack() {
		return _right;
	}
	/**
	 * method centerTrack sets the center track of the board 
	 * @return center position
	 */
	public Position[] centerTrack() {
		return _center;
	}
	/**
	 * method win is incorporated to let a player know when they have won
	 * @param s
	 * @param st
	 * @return "You Win"
	 */
	public void win(String s, String st){
		this.getWindow().dispose();
		JFrame frame = new JFrame("You Win!");
//		JButton button = new JButton("Congratulations to"+st+"("+s+")");
//		button.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				
//			}
//		});
//		frame.add(button);
		JLabel label = new JLabel("Congratulations to"+st+"("+s+")");
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}


	
//	public Position[] CommonTrack() {
//		return _common;
//	}
	
	private JFrame getWindow() {
		return _window;
		
	}

	/**
	 * method score determines a players score at a certain period in the game
	 */
	public void score(){
		String s = leftTrack()[14].toString();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			switch(c){
			case'R':{_red++;break;}
			case'B':{_blue++;break;}
			case'G':{_green++;break;}
			case'W':{_white++;break;}
			case'K':{_black++;break;} 
			case'Y':{_yellow++;break;}}}
		
			if(_playersNumber<=3){
				if(_red==10){this.win("Red",_game._s1);}
				if(_blue==10){this.win("Blue",_game._s2);}
				if(_green==10){this.win("Green",_game._s3);}
				if(_white==10){this.win("White",_game._s4);}
				if(_black==10){this.win("Black",_game._s5);}
				if(_yellow==10){this.win("Yellow",_game._s6);}
			}
			if(_playersNumber>=4){
				if(_red==6){this.win("Red",_game._s1);}
				if(_blue==6){this.win("Blue",_game._s2);}
				if(_green==6){this.win("Green",_game._s3);}
				if(_white==6){this.win("White",_game._s4);}
				if(_black==6){this.win("Black",_game._s5);}
				if(_yellow==6){this.win("Yellow",_game._s6);}
			}
			
	}

	

}
