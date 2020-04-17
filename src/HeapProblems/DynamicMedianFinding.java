package HeapProblems;

import java.util.Collections;
import java.util.PriorityQueue;

public class DynamicMedianFinding {

	public static void median(int[] arr) {
	
		PriorityQueue<Integer> greater = new PriorityQueue<>();
		PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
		double med = arr[0];
		smaller.add(arr[0]);
		System.out.println(med);
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];

			//CASE:1 left side has more elements
			if(smaller.size() > greater.size()) {
				if(cur < med) {
					greater.add(smaller.remove());
					smaller.add(cur);
				}else 
					greater.add(cur);
				
				
					med = (double)(greater.peek() + smaller.peek())/2;
				
			}
			//CASE:2 both the sides are equal
			else if (smaller.size() == greater.size()) {
				if(cur < med) {
					smaller.add(cur);
					med = (double)smaller.peek(); //or med = cur simply
				}else {
					greater.add(cur);
					med = (double)greater.peek(); //or med = cur simply
				}
			}
			//CASE:3  right side has more elements
			else {
				if(cur > med) {
					smaller.add(greater.remove());
					greater.add(cur);
				}else 
					smaller.add(cur);
				
				
					med = (double)(greater.peek() + smaller.peek())/2;
				
			}
			System.out.println(med);
		}


	}
	public static void main(String[] args) {

		int[] arr = {5, 15, 10, 20, 3};
		median(arr);;



	}

}
