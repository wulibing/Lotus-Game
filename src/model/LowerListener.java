package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LowerListener implements ActionListener {
	StartPosition _startPosition;
	/**
	 * @param startPosition assigns the instance variable startPosition. 
	 */
	public LowerListener(StartPosition startPosition){
	_startPosition=startPosition;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		_startPosition.moveTopRight();
		_startPosition.closeWindow();
	}
}
