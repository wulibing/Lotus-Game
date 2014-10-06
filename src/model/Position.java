package model;

import java.util.Stack;




public class Position {
	private int _offset;
	private int _index;
	protected Stack<Piece> _stack;
	protected Board _board;
	public boolean _goBackwards;
	
	/**
	 * @param offset assigns instance variable offset. 
	 * @param index assigns the instance variable index. 
	 * @param b assigns the instance variable board. 
	 */
	public Position(int offset, int index, Board b) {
		_offset = offset;
		_stack = new Stack<Piece>();
		_index = index;
		_board = b;
		
	}
	
	/**
	 * @return returns the height of a stack. 
	 */
	public int height() {
		return _stack.size() + _offset;
	}
	
	/**
	 * @param p pushes the piece to the next spot ont he board. 
	 */
	public void putOn(Piece p) {
		_stack.push(p);
		_board.notifyOfChange();
	}
	
	/**
	 * @return returns the first piece on the stack. 
	 */
	public Piece peekTop() {
		return _stack.peek();
	}

	/**
	 * deals with moving to a top position. 
	 */
	public void moveTop() {
		int distanceToMove = height();
		if(!_stack.isEmpty()){
			Piece p=_stack.pop();
			if(!_goBackwards){
					if(_index + distanceToMove>13){
//						_board.notifyOfChange();
						p.getTrack()[14].putOn(p);
					}
					else if(_index + distanceToMove<=13){
						p.getTrack()[_index + distanceToMove].putOn(p);
					}
			}
			else{
				if( distanceToMove==1){
					p.getTrack()[_index+1].putOn(p);
				}
				else if(distanceToMove-_index<0){
					p.getTrack()[_index-distanceToMove].putOn(p);
				}
				else if(distanceToMove-_index>0){
					p.returnStart().putOn(p);
				}
			}
		}
		_board.score();
	}
	@Override public String toString() {
		return _stack.toString();
	}
	
	/**
	 * @param offset assigns the instance variable for integer offset. 
	 */
	public void changeOffset(int offset){
		_offset=offset;
	}
	
	/**
	 * deals with moving a piece backwards on the board. 
	 */
	public void goBackwards(){
//		for(int i= .length-1 ;i>=0;i--){
//			
//		}
		
		_goBackwards=true;
	}
	
	/**
	 * @return returns integer _offset. 
	 */
	public int getOffset(){
	return _offset;
	}
	
	/**
	 * @return returns boolean _goBackwards. 
	 */
	public boolean checkBack(){
	return _goBackwards;
	}
}