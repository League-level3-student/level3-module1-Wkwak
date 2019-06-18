package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();	
	JButton b1 = new JButton("Add Name");
	JButton b2 = new JButton("View Names");
	ArrayList<String> names = new ArrayList<String>();
	
	public static void main(String[] args) {
		new _02_GuestBook().addStuff();
	}
	public void addStuff() {
		panel.add(b1);
		panel.add(b2);
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(500, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nameList = "";
		String newLine = "\n";
		if(e.getSource()==b1) {
			String name = JOptionPane.showInputDialog("Enter your name");
			names.add(name);
		}else if(e.getSource()==b2) {
			for(int i = 0; i<names.size(); i++) {
				nameList+="Guest #" + (i+1) + ": " + names.get(i) + newLine;
			}
			JOptionPane.showMessageDialog(panel,nameList);
		}
	}
	
	
	
}
