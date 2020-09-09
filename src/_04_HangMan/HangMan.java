package _04_HangMan;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame fra = new JFrame();
	JPanel pan = new JPanel();
	JLabel lab = new JLabel();
	Stack<String> words = new Stack<String>();
	String word;
	String blanks = "";
	int lives = 10;

	HangMan() {
		setup();
		inquiry();
		getNewWord();
	}

	void setup() {
		fra.add(pan);
		pan.add(lab);
		fra.setVisible(true);
		fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fra.addKeyListener(this);
		fra.setPreferredSize(new Dimension(400, 200));
		fra.pack();
	}

	void inquiry() {
		String wordCount = JOptionPane.showInputDialog("How many words would you like to try? (up to 255)");
		int numOfWords = Integer.parseInt(wordCount);

		for (int i = 0; i <= numOfWords - 1; i++) {

			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));

		}

	}

	void getNewWord() {

		if (!words.isEmpty()) {
			word = words.pop();
			//System.out.println(word);
		guessing();
		}
	}

	void guessing() {
		blanks = "";
		for (int i = 0; i < word.length(); i++) {
			blanks += "_";

		}
		lab.setText(blanks);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		if (word.contains(String.valueOf(e.getKeyChar()))) {

			for (int i = 0; i < word.length(); i++) {
				if (e.getKeyChar() == word.charAt(i)) {
					blanks = blanks.substring(0, i) + e.getKeyChar() + blanks.substring(i + 1, blanks.length());
				}
			}
			if(!blanks.contains("_")) {
				JOptionPane.showMessageDialog(null, "You guessed the word! It was " + word + "!");
				if(words.isEmpty()) {
					JOptionPane.showMessageDialog(null, "In fact, you guessed ALL the words! Good job!");
					System.exit(0);
				}
				else {
					getNewWord();
				}
			}
			
		}
		
		else {
			lives-=1;
			if(lives==0) {
				JOptionPane.showMessageDialog(null, "You Lose! You stole fizzy lifting drinks! Good day, sir!");
			System.exit(0);
			}
		}
		lab.setText(blanks);
		fra.repaint();
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
