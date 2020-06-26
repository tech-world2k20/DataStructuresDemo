package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

public class FirstMissingPositiveNo {
	
	
	static int firstMissingPositive(ArrayList<Integer> A) {
		Collections.sort(A);
		int i;
		for (i = 0; i < A.size(); i++) {
			if(A.get(i) <= 0);
			
			else break;
		}
		int j = i;
		i=1;
		for (; j < A.size(); j++) {
			if(A.get(j) != i)
				return i;
			
			else {
				i++;
				if(j+1 == A.size() && j<i)
					return i;
			}
		}

		return 1;   
	}
	
	static int firstMissingPositiveIB(ArrayList<Integer> A) {
        int len = A.size();
        for (int i = 0; i < len; i++) {
           
            while (A.get(i) != (i + 1) || A.get(i) <= 0) {
               
                int num = A.get(i);
                int targetIndex = num - 1;
            
                if ((targetIndex < 0 || targetIndex >= len) || num == A.get(num - 1)) {
                
                    break;
                }
               
                A.set(i, A.get(num - 1));
                A.set(num - 1, num);
            }
        }
        // find the missing integer
        for (int i = 0; i < len ; i++) {
            if (A.get(i) != i + 1) {
                // found missing
                return i + 1;
            }
        }
        // no missing number
        return len + 1;
    }
    
	
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(-4);
		list.add(-2);
		list.add(1);
		int res = firstMissingPositiveIB(list);
		System.out.println(res);
				
	}
}

