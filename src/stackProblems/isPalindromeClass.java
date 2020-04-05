package stackProblems;

public class isPalindromeClass  {
	
	public boolean isPalindrome(char[] charArr) {
		int i=0, j= charArr.length;
		while (i<j && charArr[i] == charArr[j-1] ) {
			i++;
			j--;
		}
		if(i<j) {
			System.out.println("not a palindrome");
			return false;
		}
		else {
			System.out.println("Palindrome");
			return true;
		}
	}
	
	public static void main(String []args) {
		isPalindromeClass obj = new isPalindromeClass();
		char[] charArr = {'a', 'b','a','x', 'a','b', 'a', 'a'};
		obj.isPalindrome(charArr);
	}
}
