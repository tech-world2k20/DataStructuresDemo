package Searching;

public class RobinKarpSearch {

	private int prime = 101;

	public int patternSearch(char[] text,int n, char[] pattern, int m) {

		long patternHash = createHash(pattern, m-1);
		long textHash = createHash(text, m-1);

		for (int i = 1; i < n-m+1; i++) {
			
			if(patternHash == textHash && checkEqual(text,i-1,i+m-2, pattern,0, m-1))
				return i-1;
			
			if(i<n-m+1)
				textHash = recalculateHash(text, i-1,i+m-1,textHash, m);
		}

		return -1;
	}

	private long recalculateHash(char[] str, int oldIndex, int newIndex, long oldHash, int patternLen) {
		long newHash = oldHash - str[oldIndex];
		newHash = newHash/prime;
		newHash += str[newIndex]*Math.pow(prime, patternLen-1);
		return newHash;
	}

	private boolean checkEqual(char[] text, int start1, int end1, char[] pattern, int start2, int end2) {
		if(end1-start1 != end2-start2)
			return false;
		
		while (start1<=end1 && start2<=end2) {
			if(text[start1] != pattern[start2])
				return false;
			
			start1++;
			start2++;
		}
		
		return true;
	}

	private long createHash(char[] str, int end) {
		long hash = 0;
		for (int j = 0; j <=end; j++) 
			hash += str[j]*Math.pow(prime, j);

		return hash;
	}

	public static void main(String[] args) {
		
		String text = "heybuddythisisAbhishek";
		int n = text.length();
		String pattern = "buddythis";
		int m = pattern.length();
		RobinKarpSearch rks = new RobinKarpSearch();
		int res =rks.patternSearch(text.toCharArray(), n, pattern.toCharArray(), m);
		System.out.println(res);

	}

}
