package _06_Intro_To_Hash_Maps;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	JFrame fra = new JFrame();
	JPanel pan = new JPanel();
	JButton addEntry = new JButton();
	JButton searchID = new JButton();
	JButton viewList = new JButton();
	JButton removeEntry = new JButton();
	HashMap<Integer, String> logSearch = new HashMap<Integer, String>();
	String existingID;
	int existingIDnumber;
	
	
	void GUI() {
		fra.add(pan);
		pan.add(addEntry);
		pan.add(searchID);
		pan.add(viewList);
		pan.add(removeEntry);
		
		fra.setVisible(true);
		fra.setPreferredSize(new Dimension(300, 100));
		fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addEntry.setText("Add entry");
		searchID.setText("Search by ID");
		viewList.setText("View List");
		removeEntry.setText("Remove entry");
		addEntry.addActionListener(this);
		searchID.addActionListener(this);
		viewList.addActionListener(this);
		removeEntry.addActionListener(this);
		fra.pack();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(addEntry)) {
			
			String ID = JOptionPane.showInputDialog("Enter an ID number.");
			String name = JOptionPane.showInputDialog("Enter a name.");
			int IDnumber = Integer.parseInt(ID);
			logSearch.put(IDnumber, name);
		}
		else if(e.getSource().equals(searchID)) {
			existingID = JOptionPane.showInputDialog("Enter an exising ID number.");
			existingIDnumber = Integer.parseInt(existingID);
			if(logSearch.get(existingIDnumber) != null) {
				JOptionPane.showMessageDialog(null, logSearch.get(existingIDnumber));
			}
			else {
				JOptionPane.showMessageDialog(null, "That value does not exist.");
			}
		}
		else if(e.getSource().equals(viewList)) {
			String printNames = "";
			for(Integer key : logSearch.keySet()) {
				printNames += "ID: " + key + "  Name: " + logSearch.get(key) + "\n";
			}
			JOptionPane.showMessageDialog(null, printNames);
		}
		else if(e.getSource().equals(removeEntry)) {
			String removalID = JOptionPane.showInputDialog("Type the ID the the person you would like to be removed.");
			int IDtoRemove = Integer.parseInt(removalID);
			if(logSearch.get(IDtoRemove) != null) {
				JOptionPane.showMessageDialog(null, logSearch.get(IDtoRemove) + " has been removed.");
				logSearch.remove(IDtoRemove);
			}
			else {
				JOptionPane.showMessageDialog(null, "That value does not exist.");
			}
		}
	}
	
	
	
	/* 
   		
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
}
