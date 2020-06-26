package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/*Given a list of non negative integers, arrange them such that they form the largest number.
 * example: Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *Note: The result may be very large, so you need to return a string instead of an integer.
 *
 */

public class LargestNumberIB {

	static String largestNumber(final List<Integer> A) {
		int[] ar = new int[10];

		for (int i = 0; i < A.size(); i++) {
			int cur = A.get(i);
			if(cur > 9) {
				while (cur >0) {
					int rem = cur%10;
					ar[rem]++;
					cur = cur/10;
				}
			}
			else ar[cur]++;
		}
		String str="";
		for (int i = ar.length-1; i>=0; i--) {
			int count = ar[i];
			for (int j = 0; j < count; j++) {
				str +=i;
			}
		}

		return str;
	}

	static String largestNo(ArrayList<Integer> A) {
		String[] arr = new String[A.size()];
		
		for (int i = 0; i < A.size(); i++) {
			arr[i] = String.valueOf(A.get(i));
		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				return (b+a).compareTo(a+b);
			}
		});
		
		StringBuilder str = new StringBuilder();
		for (String s : arr) {
			str.append(s);
		}
		if(str.charAt(0) == '0')
			return "0";
		
		return str.toString(); 
	}

	public static void main(String args[]) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(3);
		A.add(30);
		A.add(34);
		A.add(5);
		A.add(9);
		
//		A.add(0);
//		A.add(0);
//		A.add(0);
//		A.add(0);
//		A.add(0);
		
		
//		String str =largestNumber(A);
		String str = largestNo(A);
		System.out.println(str);
	}
}

