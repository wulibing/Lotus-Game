package model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.Game;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;




public class FinchListener implements ActionListener {

	private Board _board;
	private Finch _finch;
	private int _chooseSpot;
	
	/**
	 * @param board assigns the instance variable board.
	 * @param finch assigns the instance variable finch. 
	 */
	public FinchListener(Board board, Finch finch){
		_board=board;
		_finch=finch;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		_chooseSpot=0;
		while(_finch.isObstacle()){
			if(_finch.isTapped()){
				_chooseSpot++;
			}
		}
		
		
	}

	/**
	 * @return returns the integer chooseSpot. 
	 */

	/**
	 * method chooseASpot finch decides which piece to move 
	 * @return spot on the board
	 */
	public int chooseASpot(){
		return _chooseSpot;
	}

	
	
}
