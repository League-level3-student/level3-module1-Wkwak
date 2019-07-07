package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Currency;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HangMan implements KeyListener {

	JFrame frame = new JFrame("Hangman");
	JLabel label = new JLabel();
	static String labelText = "";
	static int lives = 10;
	String input = "";
	static String unknown = "";
	static String actualWord = "";
	static Stack<String> words = new Stack<String>();

	public static void main(String[] args) {
		
		HangMan hman = new HangMan();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Type in a number of words");
		int num = scanner.nextInt();

		Utilities util = new Utilities();
		for (int i = 0; i < num; i++) {
			String wordToBeAdded = util.readRandomLineFromFile("dictionary.txt");
			if (words.contains(wordToBeAdded)) {
				i--;
			} else {
				words.push(wordToBeAdded);
			}
		}
		
		String wordPushed = words.pop();
		hman.GUI(wordPushed);
		while(!words.isEmpty()) {
			if(labelText.equals(wordPushed)) {
				labelText = "";
				lives = 10; 
				wordPushed = words.pop();
				hman.GUI(wordPushed);
			}
		}

	}

	public void GUI(String word) {
		frame.setSize(300, 300);
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		
		
		for (int i = 0; i < word.length(); i++) {
			labelText += "_";
		}
		unknown = word;
		label.setText(labelText);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		input = String.valueOf(e.getKeyChar());
		System.out.println(input);
		
		if(lives <= 1) {
			JOptionPane.showMessageDialog(frame, "You Lost, Press 1 to restart");
			if(e.getKeyCode()==49 || e.getKeyCode() == 97) {
				//RESTARTING the program
				
			}
		} else {
			if (unknown.indexOf(input) == -1) {
				System.out.println("That letter is not in the word");
				lives--;
				System.out.println("You have " + lives + " guess(es) before you lose");
			} else if (unknown.contains(input)) {
				System.out.println("Correct");
				for (int i = 0; i < unknown.length(); i++) {
					if (unknown.charAt(i) == e.getKeyChar()) {
						labelText = labelText.substring(0, i) + input + labelText.substring(i+1);
					}
				}
				label.setText(labelText);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
