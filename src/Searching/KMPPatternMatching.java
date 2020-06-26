package Searching;

public class KMPPatternMatching {

	public boolean KMP(char[] text,int n, char[] pattern, int m) {

		int[] lps = computeTemporaryArray(pattern, m);
		int i=0, j=0;
		while (i<n && j<m) {
			if(text[i] == pattern[j]) {
				i++;
				j++;
			}else {
				if(j!=0)
					j = lps[j-1];
				
				else i++;
			}
		}
		if(j == m)
			return true;

		return false;
	}

	private int[] computeTemporaryArray(char[] pattern, int m) {
		int[] lps = new int[m];
		int index=0;
		for (int i = 1; i <m;  ) {
			if(pattern[i] == pattern[index]) {
				lps[i] = index+1;
				index++;
				i++;
			}else {
				if(index != 0) 
					index = lps[index-1];

				else {
					lps[i] = 0;
					i++;
				}
			}
		}

		return lps;
	}

	public static void main(String[] args) {

		String text = "heybuddythisisAbhishek";
		int n = text.length();
		String pattern = "buddythis";
		int m = pattern.length();
		
		KMPPatternMatching kmp = new KMPPatternMatching();
		boolean result = kmp.KMP(text.toCharArray(), n, pattern.toCharArray(), m);
		System.out.println(result);
	}

}
