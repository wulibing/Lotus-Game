
package model;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartPosition extends Position {
	
	private JFrame _frame;
	
	/**
	 * @param offset the starting position of the piece when clicked. 
	 * @param index the position of the piece after it is clicked. 
	 * @param b refers to the board. 
	 */
	public StartPosition(int offset, int index, Board b) {
		super(offset - 1, index, b);
	}
	
	@Override public void moveTop() {
		throw new UnsupportedOperationException();
	}

	/**
	 * deals with moving a piece top left. 
	 */
	public void moveTopLeft() {
		int distanceToMove = height();
		Piece p = _stack.pop();
		p.setTrack(_board.leftTrack());
		p.getTrack()[distanceToMove].putOn(p);
	}
	
	/**
	 * deals with moving a piece to the center. 
	 */
	public void moveTopCenter() {
		int distanceToMove = height();
		Piece p = _stack.pop();
		p.setTrack(_board.centerTrack());
		p.getTrack()[distanceToMove].putOn(p);
	}

	/**
	 * deals with moving the piece top right. 
	 */
	public void moveTopRight() {
		int distanceToMove = height();
		Piece p = _stack.pop();
		p.setTrack(_board.rightTrack());
		p.getTrack()[distanceToMove].putOn(p);
	}
	

	@Override public String toString() {
		return _stack.toString();
	}
	
	/**
	 * deals with selecting a path when the game begins. 
	 */
	public void selectPath(){
	_frame = new JFrame("Please Select Path");
	JPanel p = new JPanel();
	p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
	JButton upperButton=new JButton("Go Upper");
	upperButton.setLayout(new BoxLayout(upperButton, BoxLayout.X_AXIS));
	upperButton.setBackground(Color.red);
	JButton centerButton=new JButton("Go Center");
	centerButton.setLayout(new BoxLayout(centerButton, BoxLayout.X_AXIS));
	centerButton.setBackground(Color.yellow);
	JButton lowerButton=new JButton("Go Lower");
	lowerButton.setLayout(new BoxLayout(lowerButton, BoxLayout.X_AXIS));
	lowerButton.setBackground(Color.green);
	_frame.add(p);
	p.add(upperButton);
	p.add(centerButton);
	p.add(lowerButton);
//	_frame.setLayout(new FlowLayout());
	_frame.pack();
//	_frame.setLocation(0, getWindow().getHeight());
	upperButton.addActionListener(new UpperListener(this));
	centerButton.addActionListener(new CenterListener(this));
	lowerButton.addActionListener(new LowerListener(this));
	_frame.setVisible(true);
	}
	
	/**
	 * closes the game frame. 
	 */
	public void closeWindow(){
		_frame.dispose();
	}
}
