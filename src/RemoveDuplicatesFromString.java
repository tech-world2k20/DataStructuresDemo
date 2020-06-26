import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicatesFromString {

	static String removeDuplicate(char str[], int n){ 
		// Used as index in the modified string 
		int index = 0; 

		// Traverse through all characters 
		for (int i = 0; i < n; i++) { 
			// Check if str[i] is present before it  
			int j; 
			for (j = 0; j < i; j++){ 
				if (str[i] == str[j]) 
					break;
			} 
			// If not present, then add it to result. 
			if (j == i)  
				str[index++] = str[i]; 
		} 
		return String.valueOf(Arrays.copyOf(str, index)); 
	} 

	static void RemoveDuplicateUsingHashTable(String str, int n) {
		HashSet<Character> h = new LinkedHashSet<>();
		String s = new String();
		for (int i = 0; i <n; i++) { 
			if(h.contains(str.charAt(i)));
			
			else {
				h.add(str.charAt(i));	
				s += str.charAt(i);
			}
		}
		System.out.println(s);
		/*
		 * Iterator<Character> itr = h.iterator(); while (itr.hasNext()) {
		 * System.out.print(itr.next()); }
		 */
	}
	
	public static void RemoveDuplicateUsingIndexOf(String str, int n) {
		String s= new String();
		for (int i = 0; i < n; i++) {
			if(s.indexOf(str.charAt(i)) < 0)
				s += str.charAt(i);
		}
		
		System.out.println(s);
		
	}
	public static void main(String[] args) {

		String str = "abksdfnajaf";
		int n = str.length();
//		String s =removeDuplicate(str.toCharArray(), str.length());
//		System.out.println(s);
		
//		RemoveDuplicateUsingHashTable(str, n);
		
		RemoveDuplicateUsingIndexOf(str, n);
		
	}

}
