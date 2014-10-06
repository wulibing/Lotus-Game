package ui;

import javax.swing.SwingUtilities;

import model.Board;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Driver {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game(args));
//		if(args[0].equals("finch")){
//			Game game=new Game(args);
//			Finch finch = new Finch();
//		}
	
	}
}
