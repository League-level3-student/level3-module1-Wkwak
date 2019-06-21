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
	String unknown;
	static String actualWord = "";
	static Stack<String> words = new Stack<String>();

	public static void main(String[] args) {
		HangMan hman = new HangMan();
		

		Scanner scanner = new Scanner(System.in);
		System.out.println("Type in a number of words");
		System.out.println("You have " + lives + " guesses before you lose");
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
		actualWord = words.pop();
		
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

		if (unknown.indexOf(input) == -1) {
			System.out.println("That letter is not in the word");
			lives--;
		} else if (unknown.contains(input)) {
			System.out.println("yes");
			for (int i = 0; i < unknown.length(); i++) {
				if (unknown.charAt(i) == e.getKeyChar()) {
					labelText = labelText.substring(0, i) + input + labelText.substring(i+1);
				}
			}
			label.setText(labelText);
		}
		if(lives ==0) {
			//JOptionPane.showMessageDialog(frame, "You Lost");
		}
		
		if(labelText.equals(actualWord) && e.getKeyCode()==KeyEvent.VK_ENTER) {
			labelText="";
			label.setText(words.pop());
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
