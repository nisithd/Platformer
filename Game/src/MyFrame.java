// DeSilva Nisith
// February 14, 2020
// ICS3U7 Ms. Strelkovska
// Final Project Frame Class

// import packages
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFrame extends JFrame{
	// set up cardlayout
	static CardLayout cl;
	static Container cont;
	
	static MenuPanel menu;
	static GamePanel gameScreen;
	
	public MyFrame() {
		cont = getContentPane();
		cl = new CardLayout();
		cont.setLayout(cl);
		
		menu = new MenuPanel();
		gameScreen = new GamePanel();
		
		// add both menu and game panels to container
		cont.add("Menu", menu);
		cont.add("Game Screen", gameScreen);
	}
	
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame();
		
		// set up frame
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		myFrame.setSize(800, 800);
		myFrame.setResizable(false);
		

	}

}
