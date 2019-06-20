package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HangMan implements KeyListener{
	
	JFrame frame = new JFrame("Hangman"); 
	JLabel label = new JLabel();
	String unknown = "";
	static int lives = 5;
	String input = "";
	
	public static void main(String[] args) {
		HangMan hman = new HangMan();
		Stack<String> words = new Stack<String>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type in a number of words");
		System.out.println("You have " + lives + " guesses before you lose");
		int num = scanner.nextInt();
		
		Utilities util = new Utilities();
		for (int i = 0; i < num; i++) {
			String wordToBeAdded = util.readRandomLineFromFile("dictionary.txt");
			if(words.contains(wordToBeAdded)) {
				i--;
			}else {
				words.push(wordToBeAdded);
			}
		}
		String actualWord = words.pop();
		System.out.println(actualWord);
		hman.GUI(actualWord);
	}
	public void GUI(String word) {
		frame.setSize(300, 300);
		frame.add(label);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		for(int i = 0; i < word.length(); i++) {
			unknown+="_ ";
		}
		if(word.indexOf(input)==-1) {
			System.out.println("That letter is not in the word");
			lives--;
		}else if(word.contains(input)){
			System.out.println("yes");
			int pos = word.indexOf(input);
			if(pos == 0) {
				unknown = word.charAt(0) + unknown.substring(2);
			}
		}
		label.setText(unknown);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		input=String.valueOf(e.getKeyChar());
	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
