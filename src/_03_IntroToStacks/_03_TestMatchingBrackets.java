package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {
	Stack<String> stack = new Stack<String>();
	int countOpen = 0;
	int countClosed = 0;

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		boolean allPaired = true;
		if(b.charAt(0)=='}') {
			allPaired = false;
		}else {
			for (int i = 0; i < b.length(); i++) {
				stack.push(String.valueOf(b.charAt(i)));
			}
			while(!stack.isEmpty()) {
				String check = stack.pop();	
				if(check.equals("{")){
					countOpen++;
				}else {
					countClosed++;
				}
			}
			if(countOpen!=countClosed) {
				allPaired = false;
			}
		}
		return allPaired;
	}

}