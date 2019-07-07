package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	JFrame frame;
	JLabel label;
	JPanel panel;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	ArrayList<Integer> IDvalues = new ArrayList<Integer>();
	HashMap<Integer, String> map = new HashMap();

	public static void main(String[] args) {
		_02_LogSearch search = new _02_LogSearch();
		search.GUI();
	}

	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons.
	 * 
	 * Button 1: Add Entry When this button is clicked, use an input dialog to ask
	 * the user to enter an ID number. After an ID is entered, use another input
	 * dialog to ask the user to enter a name. Add this information as a new entry
	 * to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */

	public void GUI() {
		frame = new JFrame();
		label = new JLabel();
		panel = new JPanel();

		b1 = new JButton("Add Entry");
		b2 = new JButton("Search by ID");
		b3 = new JButton("View List");
		b4 = new JButton("Remove Entry");
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			int ID;
			ID = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID value"));
			IDvalues.add(ID);
			String name;
			name = JOptionPane.showInputDialog("Enter a name");
			map.put(ID, name);
		} else if (e.getSource() == b2) {
			int id;
			id = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID value to search for"));
			if(map.containsKey(id)) {
				JOptionPane.showMessageDialog(label, "The name belonging to the ID is " + map.get(id));
			}else {
				JOptionPane.showMessageDialog(label, "It does not exist");
			}

		} else if (e.getSource() == b3) {
			String display = "";
			for(int i = 0; i < map.size(); i++) {
				if(i == 0) {
					display = "Name: " + map.get(IDvalues.get(i)) + " ID: " + IDvalues.get(i);
				}
				else {
					display += " \n Name: " + map.get(IDvalues.get(i)) + " ID: " + IDvalues.get(i);
				}
			}
			
			JOptionPane.showMessageDialog(label, display);
		}
		else if (e.getSource() == b4) {
			int id;
			id = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID value to remove"));
			if(map.containsKey(id)) {
				map.remove(id);
			}else {
				JOptionPane.showMessageDialog(label, "It does not exist");
			}
		}
	}
}
