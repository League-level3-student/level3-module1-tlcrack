package _01_IntroToArrayLists;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame fra = new JFrame();
	JPanel pan = new JPanel();
	JButton but = new JButton();
	JButton ton = new JButton();
	ArrayList<String> guests = new ArrayList<String>();
	
	_02_GuestBook() {
		fra.add(pan);
		pan.add(but);
		pan.add(ton);
		guests.add(" Guest #1: Bob Banders" + "\n");
		guests.add(" Guest #2: Sandy Summers" + "\n");
		guests.add(" Guest #3: Greg Ganders" + "\n");
		guests.add(" Guest #4: Donny Doners" + "\n");
		display();
	}
	
	void display() {
		fra.setPreferredSize(new Dimension(400, 200));
		pan.setPreferredSize(new Dimension(400, 200));
		but.setPreferredSize(new Dimension(190, 160));
		ton.setPreferredSize(new Dimension(190, 160));
		but.setText("Add Name");
		ton.setText("View Names");
		but.addActionListener(this);
		ton.addActionListener(this);
		fra.setVisible(true);
		fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fra.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==but) {
			String s = JOptionPane.showInputDialog("Enter a name.");
			guests.add(" Guest #" + (guests.size()+1) + ": " + s + "\n");
		}
		if(e.getSource()==ton) {
			String t = "";
			for(int i = 0; i <= guests.size()-1; i++) {
				t+=guests.get(i);
			}
			JOptionPane.showMessageDialog(null, t);
		}
	}
	
}
