package _03_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	JFrame fra = new JFrame();
	JPanel pan = new JPanel();
	JLabel lab = new JLabel();
	char recentChar;
	String typed = "";
	Stack<String> deletedLetters = new Stack<String>();
	int newLines = 1;
	boolean HiTMaLls = false;

	_02_TextUndoRedo() {
		Initiate();
	}

	void Initiate() {
		fra.add(pan);
		pan.add(lab);
		fra.addKeyListener(this);
		fra.setVisible(true);
		fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fra.setPreferredSize(new Dimension(500, 500));
		fra.pack();

	}

	void Add(int keyCode) {
		if (keyCode == KeyEvent.VK_BACK_SPACE) {
			Delete();
		} else if (keyCode == KeyEvent.VK_LEFT) {
			Undo();
		} else {
			typed = typed + recentChar;

			// typed = "<html>" + typed + "</html>"
			// <br/>

			if (typed.length() * 20 > 500 * newLines) {
				typed = typed + "<br/>";
				newLines += 1;
			}

			lab.setText("<html>" + typed + "</html>");
		}
	}

	void Delete() {
		deletedLetters.push(typed.substring(typed.length() - 1));
		typed = typed.substring(0, typed.length()-1);
		lab.setText("<html>" + typed + "</html>");
	}

	void Undo() {
		if (!deletedLetters.isEmpty()) {
			typed = typed + deletedLetters.pop();
		}
		lab.setText("<html>" + typed + "</html>");
	}
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		recentChar = arg0.getKeyChar();
		Add(arg0.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
