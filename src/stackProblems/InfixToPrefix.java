package stackProblems;

public class InfixToPrefix {
	
	static int prec(char c) {
		switch (c) {
		case '+': 
		case '-': return 1;	
		
		case '*': 
		case '/': return 2;

		case '^': return 3;
		}
		return -1;
	}
	
	static String infixToPrefixMethod(String st ) throws Exception {
		
		StringBuilder str = new StringBuilder(st);
		str.reverse().toString();
		
//		System.out.println(str.toString());
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') {
				str.deleteCharAt(i);
			str.insert(i, ')');
			}
			else if(c == ')') {
				str.deleteCharAt(i);
				str.insert(i, '(');
			}
		}
		
//		System.out.println(str.toString());

		StringBuilder ans = new StringBuilder(InfixToPostfix.infixToPostfixMethod(str.toString()));
		return ans.reverse().toString();
	}

	public static void main(String[] args) throws Exception {
		
		String str = "A*B-(C+D)+E";
		String str1 = "a+b*(c^d-e)^(f+g*h)-i";
		String res = infixToPrefixMethod("(a-b/c)*(a/k-l)");
		System.out.println(res);
	}

}
