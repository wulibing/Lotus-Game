package model;

import java.awt.Color;


public class Piece {
	
	private String _string;
	private Position[] _track;
	public Position _start;

	/**
	 * @param start assigns an instance variable for start.
	 * @param s assigns the instance variable for string. 
	 */
	public Piece(Position start, String s) {
		_start=start;
		_string = s;
	}
	
	/**
	 * @param track assigns the instance variable for track. 
	 */
	public void setTrack(Position[] track) {
		_track = track;
	}
	
	@Override public String toString() {
		return _string;
	}

	/**
	 * @return returns the track position. 
	 */
	public Position[] getTrack() {
		return _track;
	}
	
	
	/**
	 * @return returns the start position. 
	 */
	public Position returnStart(){
		return _start;
	}


}
