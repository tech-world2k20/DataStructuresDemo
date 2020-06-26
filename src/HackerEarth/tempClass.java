package HackerEarth;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	//1 2 2 4
	static long countTripletsHackerRank(List<Long> arr, long r) {
		Map<Long, Long> potential = new HashMap<>();
		Map<Long, Long> counter = new HashMap<>();
		long count = 0;
		for (int i = 0; i < arr.size(); i++) {
			long a = arr.get(i);
			long key = a / r;

			if (counter.containsKey(key) && a % r == 0) 
				count += counter.get(key);


			if (potential.containsKey(key) && a % r == 0) {
				long c = potential.get(key);
				counter.put(a, counter.getOrDefault(a, 0L) + c);
			}

			potential.put(a, potential.getOrDefault(a, 0L) + 1); // Every number can be the start of a triplet.
		}
		return count;
	}

	//1 2 2 4   r=2
	static long countTriplets(List<Long> arr, long r) {
		Map<Long, Long> left = new HashMap<>();
		Map<Long, Long> right = new HashMap<>();
		long count = 0;

		for (int i = 0; i < arr.size(); i++) 
			right.put(arr.get(i), right.getOrDefault(arr.get(i), 0L)+1);

		for (int i = 0; i < arr.size(); i++) {
			long cl = 0,cr=0;

			long mid = arr.get(i);
			right.put(mid, right.getOrDefault(mid, 0L) -1);

			if(left.containsKey(mid/r) && mid%r==0) 
				cl = left.get(mid/r);

			if(right.containsKey(mid*r)) 
				cr = right.get(mid*r);

			count +=cl*cr;

			left.put(mid, left.getOrDefault(mid, 0L)+1);
		}

		return count;
	}

	static boolean isPrime(int n){  
		int i,m=0,flag=0;   
		m=n/2;      
		if(n==0||n==1)return false;

		else{  
			for(i=2;i<=m;i++){      
				if(n%i==0){      
					flag=1;      
					break;      
				}      
			}      
			if(flag==0)  
				return true;;
		}
		return false;
	}  


	public static ArrayList<Integer> prime(int n) {
		ArrayList<Integer> primeArr =new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			if(isPrime(i))
				primeArr.add(i);
		}

		return primeArr;
	}
	
	

	public static void main(String[] args) {
		tempClass t = new tempClass();
		int[] k= {1,2,3,9,10,12};
		int A = 7;
		int res =t.cookies(A, k);
		//		System.out.println(res);
		//		System.out.printf("%d %d %d", A,A,A).println();
		//		byte c = 127;
		//		int hexa =0x10; 
		//		int octa = 077;
		//		float f = 3.98f;
		//		double d = 1/2;
		//		f = (float) d;
		//		System.out.println(d);
		//		System.out.println(hexa);
		//		System.out.println(octa);

		List<Long> arr = new ArrayList<Long>();
		//		for (int i = 0; i < 100; i++) {
		//			arr.add((long) 1);
		//		}
		//		arr.add((long) 1);
		//		arr.add((long) 2);
		//		arr.add((long) 2);
		//		arr.add((long) 4);
		//		
		//		long result =countTriplets(arr, 2);
		//		System.out.println(result);
		//		


		ArrayList<Integer> prime = prime(10);
		for (Integer i : prime) {
			System.out.print(i+" ");
		}
	}

}
