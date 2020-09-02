package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	JFrame fra = new JFrame();
	JPanel pan = new JPanel();
	JLabel lab = new JLabel();
	Stack<String> words = new Stack<String>();
	String word;
	String blanks = "";

		
	HangMan(){
		JSetup();
		Inquiry();
		
		while(!words.isEmpty()) {
			word = words.pop();
			Guessing();
		}
	}
	void JSetup() {
		fra.add(pan);
		pan.add(lab);
		fra.setVisible(true);
		fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fra.addKeyListener(this);
	}
	void Inquiry() {
		String wordCount = JOptionPane.showInputDialog("How many words would you like to try? (up to 255)");
		int numOfWords = Integer.parseInt(wordCount);
		
		for(int i = 0; i<= numOfWords-1; i++) {
		
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));

		}
		
		
	}
	void Guessing() {
		for(int i = 0; i < word.length(); i++) {
			blanks += "_";
			
		}
		lab.setText(blanks);
		
		
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < word.length(); i++) {
			if(e.getKeyChar()==word.charAt(i)) {
				blanks = blanks.substring(0, i) + e.getKeyChar() + blanks.substring(i+1, blanks.length());
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
