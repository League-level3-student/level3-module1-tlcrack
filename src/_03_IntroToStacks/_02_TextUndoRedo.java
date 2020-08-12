package _03_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	JFrame fra = new JFrame();
	JPanel pan = new JPanel();
	JLabel lab = new JLabel();
	char recentChar;
	
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
	 
	 void Add() {
		 if(recentChar==KeyEvent.VK_BACK_SPACE) {
			  Delete();
		 }
		 if(recentChar==KeyEvent.VK_LEFT) {
			 Undo()
		 }
		 else {
			 
		 }
	 }
	 
	 void Delete() {
		 
	 }
	 
	 void Undo() {
		 
	 }
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time tshe BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		recentChar =  arg0.getKeyChar();
		Add();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
