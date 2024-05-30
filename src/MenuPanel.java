// DeSilva Nisith
// February 14, 2020
// ICS3U7 Ms. Strelkovska
// Final Project Menu Class

// import packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class MenuPanel extends JPanel implements ActionListener{
	// make buttons, layout background image
	private JButton play, instructions, exit;
	private JPanel p1;
	ImageIcon bg;
	
	// constructor
	public MenuPanel() {
		
		this.setLayout(new BorderLayout());
		
		bg = new ImageIcon("menuBackground.png");
		
		// make the buttons appear on the bottom
		p1 = new JPanel();
		this.add(p1, BorderLayout.SOUTH);
		p1.setLayout(new GridLayout(1, 3));
		
		play = new JButton("Play");
		instructions = new JButton("Instructions");
		exit = new JButton("Exit");
		
		p1.add(play);
		p1.add(instructions);
		p1.add(exit);
		
		play.addActionListener(this);
		instructions.addActionListener(this);
		exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton pressed = (JButton)e.getSource();
		
		if(pressed == play) {
			// move to the game panel if play is pressed
			MyFrame.cl.next(MyFrame.cont);
			MyFrame.menu.setFocusable(false);
			play.setFocusable(false);
			instructions.setFocusable(false);
			exit.setFocusable(false);
			MyFrame.gameScreen.setFocusable(true);
			MyFrame.gameScreen.requestFocusInWindow();
			MyFrame.gameScreen.timer.start();
		}
		// instructions message
		else if(pressed == instructions) {
			JOptionPane.showMessageDialog(null, "Welcome to Just Another Platformer! \n"
					+ "\nThis is a 2-D platform game where the player must traverse "
					+ "\neach level and reach the exit in order to pass. There are "
					+ "\nvarious obstacles along the way, including pits and enemies "
					+ "\nto avoid. "
					+ "\n To move the player left and right, use arrow keys, and the up "
					+ "\nkey to jump.", "Instructions", JOptionPane.INFORMATION_MESSAGE ); 
		}
		else if(pressed == exit) {
			System.exit(0);
		}
	}
	
	// paint method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.lightGray);
		
		g.drawImage(bg.getImage(), 0, 0, null);
		g.setFont(new Font("MonoSpaced", Font.BOLD, 48));
		g.drawString("Just Another Platformer", 50, 200);
		g.setFont(new Font("MonoSpaced", Font.BOLD, 24));
		g.drawString("By: Nisith", 340, 250);
	}
}
