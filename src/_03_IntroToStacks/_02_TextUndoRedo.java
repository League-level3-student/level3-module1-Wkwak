package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class _02_TextUndoRedo implements KeyListener {
	JFrame frame = new JFrame();
	Stack<String>deleted=new Stack<String>();
	JLabel label = new JLabel("You typed: ");
	String word = "";

	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	public static void main(String[] args) {
		new _02_TextUndoRedo().GUI();
		

	}

	public void GUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char input = e.getKeyChar();
		word+=String.valueOf(input);
		if(e.getKeyCode()==VK_BACKSPACE) {
			int lastPos = word.length()-1;
			String lastChar = String.valueOf(word.charAt(lastPos));
			label.setText("You typed: " + word.substring(0,lastPos));
			deleted.push(lastChar);
		}else if(e.getKeyCode()==VK_ENTER) {
			label.setText("You typed: " + word + deleted.pop());
		}
		
		else {
			System.out.println(input);
			label.setText(label.getText() + input);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
