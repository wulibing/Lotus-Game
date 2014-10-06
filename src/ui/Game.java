package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Board;
import model.CenterListener;
import model.FinchListener;
import model.Position;
import model.StartPosition;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Game implements Runnable, ActionListener {
	
	private ArrayList<JButton> _buttons;
	private Board _board;
	private String[] _players;
	public int _playersNumber;
	private JPanel[] _start;
	public int _startNumber;
	public boolean _controllerFinch;
	private Finch _finch;
//	private Color[] _color = {Color.RED,Color.BLUE,Color.GREEN,Color.WHITE,Color.BLACK,Color.YELLOW};
	public String _s1;
	public String _s2;
	public String _s3;
	public String _s4;
	public String _s5;
	public String _s6;
	private int _turn;
	private FinchListener _finchListener;

	
	/**
	 * @param args determines if you use a mouse or finch controller. 
	 */
	public Game(String[] args) {
		if(args[0].equals("mouse")){
			_controllerFinch=false;
			_playersNumber = args.length-1;
			_players = new String[_playersNumber];
			if(_playersNumber>=2&&_playersNumber<=6){
				for(int i=1;i<=_playersNumber;i++){
				_players[i-1]=args[i];
				}
				_board = new Board(_playersNumber, this);
				_board.setActionListener(this);
			}
			else if(_playersNumber<2){
				JFrame window = new JFrame("Warm Tip");
				window.getContentPane().add(new JLabel("Need at least 2 players"));
				window.pack();
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setVisible(true);

			}
			else if(_playersNumber>6){
				JFrame window = new JFrame("Warm Tip");
				window.getContentPane().add(new JLabel("Can have at most 6 players"));
				window.pack();
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setVisible(true);
			}
//			for (int i=1; i<args.length; i++){
//				_players[i-1]=args[i];
//			}
			
			}
		else if(args[0].equals("finch")){
			_controllerFinch=true;
			_playersNumber = args.length-1;
			_players = new String[_playersNumber];
			if(_playersNumber>=2&&_playersNumber<=6){
				for(int i=1;i<=_playersNumber;i++){
				_players[i-1]=args[i];
				}
				_board = new Board(_playersNumber, this);
				_board.setActionListener(this);
			}
			else if(_playersNumber<2){
				JFrame window = new JFrame("Warm Tip");
				window.getContentPane().add(new JLabel("Need at least 2 players"));
				window.pack();
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setVisible(true);

			}
			else if(_playersNumber>6){
				JFrame window = new JFrame("Warm Tip");
				window.getContentPane().add(new JLabel("Can have at most 6 players"));
				window.pack();
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setVisible(true);
			}
//			_finch = new Finch();
			new FinchListener(_board, _finch);

			
		}
		else{
			JFrame window = new JFrame("Warm Tip");
			window.getContentPane().add(new JLabel("Have to use neither a mouse or a finch as a controller"));
			window.pack();
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setVisible(true);
		}
		
		if(_playersNumber==2){
			_s1 = args[1];
			_s2 = args[2];
		}
		if(_playersNumber==3){
			_s1 = args[1];
			_s2 = args[2];
			_s3 = args[3];
		}
		if(_playersNumber==4){
			_s1 = args[1];
			_s2 = args[2];
			_s3 = args[3];
			_s4 = args[4];
		}
		if(_playersNumber==5){
			_s1 = args[1];
			_s2 = args[2];
			_s3 = args[3];
			_s4 = args[4];
			_s5 = args[5];
		}
		if(_playersNumber==6){
			_s1 = args[1];
			_s2 = args[2];
			_s3 = args[3];
			_s4 = args[4];
			_s5 = args[5];
			_s6 = args[6];
		}


	}
	
	
	@Override public void run() {
		JFrame window = new JFrame("Lotus - Stage 2 - Group s");
		Container c = window.getContentPane();
		c.setLayout(new BoxLayout(c,BoxLayout.X_AXIS));

		JPanel start = new JPanel();
		start.setLayout(new BoxLayout(start, BoxLayout.Y_AXIS));
		
//		_start = new JPanel[_playersNumber];
//		for(int i=0;i<_playersNumber;i++){
//		_start[i] = new JPanel();
//		_start[i].setLayout(new BoxLayout(_start[i], BoxLayout.X_AXIS));
//		}
		
//		_playersNumber=_players.length;
//		_start = new JPanel[_playersNumber];
//		if(_playersNumber==2||_playersNumber==3){
//			for(int i=0;i<_playersNumber;i++){
//				_start[i] = new JPanel();
//				_start[i].setLayout(new BoxLayout(_start[i], BoxLayout.X_AXIS));
//				start = _start[i];
//			}
//		}
//		else if(_playersNumber==4||_playersNumber==5||_playersNumber==6){
//			for(int i=0;i<_playersNumber;i++){
//				_start[i] = new JPanel();
//				_start[i].setLayout(new BoxLayout(_start[i], BoxLayout.X_AXIS));
//			}
//			else{
//				throw new NullPointerException;
//			}
			
//		}
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

		JPanel upperLeft = new JPanel();
		upperLeft.setLayout(new BoxLayout(upperLeft, BoxLayout.X_AXIS));
		
		JPanel centerLeft = new JPanel();
		centerLeft.setLayout(new BoxLayout(centerLeft, BoxLayout.X_AXIS));

		JPanel lowerLeft = new JPanel();
		lowerLeft.setLayout(new BoxLayout(lowerLeft, BoxLayout.X_AXIS));

		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.X_AXIS));
		
		_start = new JPanel[_playersNumber];
		for(int i = 0; i < _playersNumber; i++){
			_start[i] = new JPanel();
			_start[i].setLayout(new BoxLayout(_start[i], BoxLayout.X_AXIS));
			}
		
		
//		JPanel startRed = new JPanel();
//		startRed.setLayout(new BoxLayout(startRed, BoxLayout.X_AXIS));
//
//		JPanel startBlue = new JPanel();
//		startBlue.setLayout(new BoxLayout(startBlue, BoxLayout.X_AXIS));
//		
//		JPanel startGreen = new JPanel();
//		startGreen.setLayout(new BoxLayout(startGreen, BoxLayout.X_AXIS));
//		
//		JPanel startWhite = new JPanel();
//		startWhite.setLayout(new BoxLayout(startWhite, BoxLayout.X_AXIS));
//		
//		JPanel startBlack = new JPanel();
//		startBlack.setLayout(new BoxLayout(startBlack, BoxLayout.X_AXIS));
//		
//		JPanel startYellow = new JPanel();
//		startYellow.setLayout(new BoxLayout(startYellow, BoxLayout.X_AXIS));
//		
//
//		if(_playersNumber==2){
//
//			start.add(startRed);
//			start.add(startBlue);
//
//		}
//		if(_playersNumber==3){
//
//			start.add(startRed);
//			start.add(startBlue);
//			start.add(startGreen);
//
//		}
//		if(_playersNumber==4){
//
//			start.add(startRed);
//			start.add(startBlue);
//			start.add(startGreen);
//			start.add(startWhite);
//
//		}
//		if(_playersNumber==5){
//
//			start.add(startRed);
//			start.add(startBlue);
//			start.add(startGreen);
//			start.add(startWhite);
//			start.add(startBlack);
//
//		}
//		if(_playersNumber==6){
//
//			start.add(startRed);
//			start.add(startBlue);
//			start.add(startGreen);
//			start.add(startWhite);
//			start.add(startBlack);
//			start.add(startYellow);
//
//		}
		
	
		for(int i = 0; i < _playersNumber; i++){
			start.add(_start[i]);
			}
		
		c.add(start);
		c.add(left);
		c.add(right);
		left.add(upperLeft);
		left.add(centerLeft);
		left.add(lowerLeft);

		
		_buttons = new ArrayList<JButton>();
		if(_playersNumber<=3){
			_startNumber=4;
			}else{_startNumber=3;}
//		if(_playersNumber==2){
//			for (int i=0; i<4; i++) {
//				createStartButton(startRed, _board.getRedStart(i));
//				createStartButton(startBlue, _board.getBlueStart(i));
//			}
//		}
//		else if(_playersNumber==3){
//			for (int i=0; i<4; i++) {
//				createStartButton(startRed, _board.getRedStart(i));
//				createStartButton(startBlue, _board.getBlueStart(i));
//				createStartButton(startGreen, _board.getGreenStart(i));
//			}
//		}
//		else if(_playersNumber==4){
//			for (int i=0; i<3; i++) {
//				createStartButton(startRed, _board.getRedStart(i));
//				createStartButton(startBlue, _board.getBlueStart(i));
//				createStartButton(startGreen, _board.getGreenStart(i));
//				createStartButton(startWhite, _board.getWhiteStart(i));
//			}
//		}
//		else if(_playersNumber==5){
//			for (int i=0; i<3; i++) {
//				createStartButton(startRed, _board.getRedStart(i));
//				createStartButton(startBlue, _board.getBlueStart(i));
//				createStartButton(startGreen, _board.getGreenStart(i));
//				createStartButton(startWhite, _board.getWhiteStart(i));
//				createStartButton(startBlack, _board.getBlackStart(i));
//			}
//		}
//		else if(_playersNumber==6){
//			for (int i=0; i<3; i++) {
//				createStartButton(startRed, _board.getRedStart(i));
//				createStartButton(startBlue, _board.getBlueStart(i));
//				createStartButton(startGreen, _board.getGreenStart(i));
//				createStartButton(startWhite, _board.getWhiteStart(i));
//				createStartButton(startBlack, _board.getBlackStart(i));
//				createStartButton(startYellow, _board.getYellowStart(i));
//			}
//		}
//		if(_playersNumber==2||_playersNumber==3){
//			for (int i=0; i<4; i++) {
//				createStartButton(startRed, _board.getRedStart(i));
//				createStartButton(startBlue, _board.getBlueStart(i));
//				createStartButton(startGreen, _board.getGreenStart(i));
//				createStartButton(startWhite, _board.getWhiteStart(i));
//				createStartButton(startBlack, _board.getBlackStart(i));
//				createStartButton(startYellow, _board.getYellowStart(i));
//			}
//		}
//		if(_playersNumber==4||_playersNumber==5||_playersNumber==6){
//			for (int i=0; i<3; i++) {
//				createStartButton(startRed, _board.getRedStart(i));
//				createStartButton(startBlue, _board.getBlueStart(i));
//				createStartButton(startGreen, _board.getGreenStart(i));
//				createStartButton(startWhite, _board.getWhiteStart(i));
//				createStartButton(startBlack, _board.getBlackStart(i));
//				createStartButton(startYellow, _board.getYellowStart(i));
//			}
//		}
		
		for (int i=0; i<_playersNumber;i++){
			for(int j=0;j <_startNumber;j++){
			createStartButton(_start[i], _board.getStart(i,j));
			}
		}
		
		for (int i=0; i<3; i++) {
			createTrackButton(upperLeft, _board.getLeft(i));
			createTrackButton(centerLeft, _board.getCenter(i));
			createTrackButton(lowerLeft, _board.getRight(i));
		}
		for (int i=3; i<14; i++) {
			createTrackButton(right, _board.getCommon(i));
		}
		specialPoints();
		update(_board.getBoard());

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
//		if(_playerAccount==2||_playerAccount==3){
//			_startNumber=4;
//		}
//		else if(_playerAccount==4||_playerAccount==5||_playerAccount==6){
//			_startNumber=3;
//		}
//		for(int i=0; i<_playerAccount;i++){
//			for(int j=0;j<_startNumber;j++){
//
//		}
	}

	/**
	 * @param panel creates a panel for the start button. 
	 * @param pos creates a starting position. 
	 */
	public void createStartButton(JPanel panel, StartPosition pos) {
		createButton(panel, new StartHandler(pos));
	}

	/**
	 * @param panel creates a panel for the track button.
	 * @param pos creates a tracking position. 
	 */
	public void createTrackButton(JPanel panel, Position pos) {
		createButton(panel, new TrackHandler(pos));
	}

	private void createButton(JPanel panel, ActionListener listener) {
		JButton b;
		b = new JButton();
		b.setBackground(Color.orange);
		panel.add(b);
		b.addActionListener(listener);
		_buttons.add(b);
	}

	@Override 
	public void actionPerformed(ActionEvent e) {
	
			update(_board.getBoard());

	}
	
	

	private void update(ArrayList<String> board) {
		Color[] color = {Color.RED,Color.BLUE,Color.GREEN,Color.orange,Color.magenta,Color.YELLOW};
		
		for (int i=0; i<_buttons.size(); i++) {
			_buttons.get(i).setText(board.get(i));
		}
		
		if(_turn>_playersNumber-1){
			_turn=0;
		}
		else{
			_turn++;
		}
		
		
		if(this.getFinch()!=null){
			this.getFinch().setLED(color[_turn-1]);
			int a=_finchListener.chooseASpot();
			_buttons.get(a).addActionListener(new CenterListener(null));
		}
	}

	/**
	 *  creates the random special points. 
	 */
	public void specialPoints(){
		Random r = new Random();
		int sp2 = r.nextInt(14);
		int sp5 = r.nextInt(14);
		int spb = r.nextInt(14);
		int ucl = r.nextInt(3);
		while(sp2==sp5||sp2==spb||sp5==spb){
			sp2 = r.nextInt(14);
			sp5 = r.nextInt(14);
			spb = r.nextInt(14);
		}
		if(ucl==0){
		_board.getLeft(sp2).changeOffset(2);
		_board.getLeft(sp5).changeOffset(5);
		_board.getLeft(spb).goBackwards();
		}
		if(ucl==1){
		_board.getCenter(sp2).changeOffset(2);
		_board.getCenter(sp5).changeOffset(5);
		_board.getCenter(spb).goBackwards();
		}
		if(ucl==2){
		_board.getRight(sp2).changeOffset(2);
		_board.getRight(sp5).changeOffset(5);
		_board.getRight(spb).goBackwards();
		}
		
	}
	/**
	 * @return returns the finch. 
	 */
	public Finch getFinch(){
		return _finch;
	}
	

	
}

