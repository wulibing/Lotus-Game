package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpperListener implements ActionListener {
	
	StartPosition _startPosition;
	
	/**
	 * @param startPosition assigns the instance variable startPosition. 
	 */
	public UpperListener(StartPosition startPosition){
	_startPosition=startPosition;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		_startPosition.moveTopLeft();
		_startPosition.closeWindow();
	}

}
