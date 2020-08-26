package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	JFrame fra = new JFrame();
	JPanel pan = new JPanel();
	JLabel lab = new JLabel();
	Stack<String> words = new Stack<String>();
		
		
	HangMan(){
		JSetup();
		Inquiry();
		
	}
	void JSetup() {
		fra.add(pan);
		pan.add(lab);
		fra.setVisible(true);
		fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void Inquiry() {
		String wordCount = JOptionPane.showInputDialog("How many words would you like to try? (up to 255)");
		int numOfWords = Integer.parseInt(wordCount);
		
		for(int i = 0; i<= numOfWords-1; i++) {
		words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		
		}
		
		
		
	}
	
	
	
	
	
}
