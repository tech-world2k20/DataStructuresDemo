package InterviewBit;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstRepeatedNumber {
	
	public int repeatedNumber(final List<Integer> A) {
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < A.size(); i++) {
			if(set.contains(A.get(i)))
				return A.get(i);
			
			else set.add(A.get(i));
		}
		
		
		return -1;
	        
	    }
}

