package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CenterListener implements ActionListener{
	
	StartPosition _startPosition;
	/**
	 * @param startPosition assigns an instance variable.
	 */
	public CenterListener(StartPosition startPosition){
	_startPosition=startPosition;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		_startPosition.moveTopCenter();
		_startPosition.closeWindow();
	}
	

}
