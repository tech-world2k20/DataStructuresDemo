package stackProblems;

import java.util.Stack;

public class InfixToPostfix {
	
	static int prec(char c) {
		switch (c) {
		case '+':
		case '-':	return 1;
		
		case '*':
		case '/':	return 2;
		
		case '^':	return 3;
			
		}
		return -1;
	}
	
	static String infixToPostfixMethod(String str) throws Exception {
		Stack<Character> stack = new Stack<>();
		String res = "";
		
		//A*B-(C+D)+E --> AB*CD+-E
		for (int i = 0; i < str.length(); i++) {
			char chr = str.charAt(i);
			
			if(Character.isLetterOrDigit(chr))
				res += chr;
			
			else if(chr == '(')
				stack.push(chr);
			
			else if(chr == ')') {
				while(!stack.isEmpty() && stack.peek() != '(')
					res += stack.pop();
				
				stack.pop();
			}
			
			else {
				while(!stack.isEmpty() && prec(chr) <= prec(stack.peek())) {
					if(stack.peek() == '(')
						throw new Exception("invalid Expression");
					
					res += stack.pop();
				}
					
				stack.push(chr);
				
			}
			
		}
		while(!stack.isEmpty())
			res += stack.pop();
		
		return res;
	}

	public static void main(String[] args) throws Exception {
		String str = "A*B-(C+D)+E";
		String str1 = "a+b*(c^d-e)^(f+g*h)-i";
		String res = infixToPostfixMethod(str1);
		System.out.println(res);
//		System.out.println("\n" +Integer.bitCount(7));

	}

}
