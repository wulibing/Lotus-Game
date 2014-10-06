package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StartPosition;

public class StartHandler implements ActionListener {

	private StartPosition _pos;

	/**
	 * @param pos refers to the start position when game is started. 
	 */
	public StartHandler(StartPosition pos) {
		_pos = pos;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		_pos.selectPath();
	}

}
