package test;

import static org.junit.Assert.assertTrue;

import java.awt.Color;

import model.Piece;
import model.Player;
import model.Position;
import model.StartPosition;

public class Test {

	@org.junit.Test
	public void testPosition1() {
		Position p=new Position(0, 0, null);
		boolean expected=false;
		boolean actual=p.checkBack();
		assertTrue("",expected==actual);
	}
	@org.junit.Test
	public void testPosition2() {
		Position[] p = new Position[1];
		int expected=1;
		int actual=p.length;
		assertTrue("",expected == actual);
	}
	@org.junit.Test
	public void testPosition3() {
		Position p= new Position(0, 0, null);

		boolean expected= true;
		boolean actual=!p._goBackwards;


		assertTrue("",expected==actual);
	}
	@org.junit.Test
	public void testPosition4() {
		Position p=new Position(0, 0, null);
		boolean expected = false;
		Object obj = null;
		boolean actual= p.equals(obj);
		assertTrue("",expected==actual);
	}
	@org.junit.Test
	public void testPosition5() {
		Position p=new Position(0, 0, null);
		int expected=0;
		int actual= p.height();
		assertTrue("",expected==actual);
	}
	@org.junit.Test
	public void testPosition6() {

//		Position p=new Position(0, 0, null);
//		int expected=1;
//		int actual= p.hashCode();
//		assertTrue("",expected==actual); 

		Position p = new Position(0, 0, null);
		boolean expected = true;
		boolean actual =!p.checkBack();
		assertTrue("",expected==actual);
	}
//	@org.junit.Test
//	public void testPosition7() {
//		Position p = new Position(0, 0, null);
//		int expected = 0;
//		int actual = p.peekTop();
//		assertTrue("",expected==actual);
//	}
//	@org.junit.Test
//	public void testPosition8() {
//		Position p = new Position(0, 0, null);
//		int expected = 0;
//		int actual = p.hashCode();
//		assertTrue("",expected==actual);
//
//	}
	@org.junit.Test
	public void testPlayer() {
		Color c = null;
		Player b = new Player(c);
		boolean expected=true;
		boolean actual=b.getClass() != null;
		assertTrue("",expected == actual);
	}
	@org.junit.Test
	public void testStartPosition() {
		StartPosition sp = new StartPosition(0, 0, null);
		boolean expected=true;
		boolean actual=sp.getClass() != null;
		assertTrue("",expected == actual);
	}

//	@org.junit.Test
//	public void testPiece1() {
//		Piece sp = new Piece(toString());
//		boolean expected=true;
//		boolean actual=sp.getClass() != null;
//		assertTrue("",expected == actual);
//	}
//	@org.junit.Test
//	public void testPiece2() {
//		Piece sp = new Piece(toString());
//		Position p=new Position(0, 0, null);
//		boolean expected=true;
//		boolean actual=sp.getClass() != null;
//		assertTrue("",expected == actual);
//	}
//	@org.junit.Test
//	public void testPiece3() {
//		Piece sp = new Piece(toString());
//		boolean expected=true;
//		boolean actual=sp.toString() != null;
//		assertTrue("",expected == actual);
//	}

}