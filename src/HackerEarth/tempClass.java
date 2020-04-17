package HackerEarth;

import java.util.Comparator;
import java.util.PriorityQueue;

public class tempClass {

	int cookies(int k, int[] A) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for (int i = 0; i < A.length; i++) 
			priorityQueue.add(A[i]);
		int  count=0;
		while (priorityQueue.size()>1 && priorityQueue.peek() < k) {

				priorityQueue.add(priorityQueue.poll() + priorityQueue.poll()*2);
				count++;
				
				if(priorityQueue.peek() > k) return -1;
			}
			
		return count;
	}
	
	class Player {
		String name;
		int score;

		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

	class Checker implements Comparator<Player> {
	  	// complete this method
		public int compare(Player a, Player b) {
	       if(a.score == b.score) 
	            return a.name.compareTo(b.name);
	        
	        else 
	            return Integer.valueOf(b.score).compareTo(a.score);
	        
	    }
	}

	public void somemethod(int... values) {
		
	}
	public static void main(String[] args) {
		tempClass t = new tempClass();
		int[] k= {1,2,3,9,10,12};
		int A = 7;
		int res =t.cookies(A, k);
		System.out.println(res);
		System.out.printf("%d %d %d", A,A,A).println();
		byte c = 127;
		int hexa =0x10; 
		int octa = 077;
		float f = 3.98f;
		double d = 1/2;
		f = (float) d;
		System.out.println(d);
		System.out.println(hexa);
		System.out.println(octa);



	}

}
