package CLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CircularMenShooting {

	static void methodUsingCLinkedList(int n) {
		CLLNode headNode = new CLLNode(), tempNode;
		headNode.setData(1);

		tempNode = headNode;
		for (int i = 2; i <=n; i++) {
			CLLNode cur = new CLLNode(i);
			tempNode.setNext(cur);
			tempNode = tempNode.getNext();
		}

		tempNode.setNext(headNode);

		int size = headNode.size(headNode);

		while (size != 1){
			headNode.setNext(headNode.getNext().getNext());
			headNode = headNode.getNext();
			size--;
		}

		System.out.println(headNode.getData());
	}

	static int josephus(int n, int k) 
	{ 
		if (n == 1) 
			return 1; 
		else
			/* The position returned by josephus(n - 1, k) is adjusted because the recursive call josephus(n - 1, k) considers the original
			 * position k%n + 1 as position 1 */
			return (josephus(n - 1, k) + k-1) % n + 1; 
	} 

	static ArrayList<Integer> method(ArrayList<Integer> list) {
		int num=0;
		Collections.reverse(list);
		Iterator<Integer> itr = list.iterator();
		int i=1;
		while (itr.hasNext()) {
			num += itr.next()*i;
			i = i*10;
		}
		num++;
		list = new ArrayList<>();
		while(num >0) {
			int lastDigit = num%10;
			list.add(lastDigit);
			num /=10;
		}

		Collections.reverse(list);

		return list;
	}

	static ArrayList<Integer> method1(ArrayList<Integer> a){
		int i = 0;
		//remove zeroes at the front
		while (i < a.size() - 1 && a.get(i) == 0) {
			a.remove(i);
		}

		int carry = 1;
		int sum;
		for (i = a.size() - 1; i >= 0; i--) {
			sum = a.get(i) + carry;
			a.set(i, sum % 10);
			carry = sum / 10;
			// no need of further processing if carry is zero
			if (carry == 0) {
				break;
			}
		}
		// if carry is still left
		if (carry != 0) {
			a.add(0, carry);
		}
		return a;
	}

	static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		int reminder = 0;
		while (A.size() > 1 && A.get(0) == 0) {
			A.remove(0);
		}
		for (int i = A.size() - 1; i >= 0; i--) {
			int num = A.get(i);
			if(num == 9){
				A.remove(i);
				A.add(i,0);
				reminder = 1;
			}else{
				A.remove(i);
				A.add(i,num+1);
				reminder = 0;
				break;
			}
		}
		if(reminder == 1){
			A.add(0,1);
		}
		return A;
	}


	static int repeatedNumber1(final List<Integer> a) {

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>(); 

		for (int i = 0; i < a.size(); i++) 
			hmap.put(a.get(i), hmap.getOrDefault(a.get(i), 0)+1);

		for (Map.Entry<Integer, Integer> entry : hmap.entrySet())  
			if(entry.getValue() > a.size()/3)
				return entry.getKey();

		return -1;
	}

	static  ArrayList<Integer> repeatedNumber(final List<Integer> A) {
		int n = A.size();
		ArrayList<Integer> res = new ArrayList<>();
		int repeat=0, missing=0;
		long sum=0;
		Collections.sort(A);
		int j=1;
		for(int i=0;i<n-1; i++){
			if(A.get(i) == A.get(i+1))
				repeat = A.get(i);
			
			sum += A.get(i);
		}
		
		missing = (int)  (int) ((1L * n * (1L * n + 1)) / 2 - sum + repeat);

		res.add(repeat);
		res.add(missing);

		return res;
	}

	public static void main(String[] args) {


		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(2);

		repeatedNumber(list);
		//		list.add(3);
		//		System.out.println(list.get(list.size()-1));
		//		method1(list);
		//		plusOne(list);
		//		int noOfPersons = 101;
		//		int gap = 2;
		//
		//		methodUsingCLinkedList(noOfPersons);
		//		System.out.println(josephus(noOfPersons, gap));
		//
		//		int i = 010;
		//		int j = 07;
		//		System.out.println(i);
		//		System.out.println(j);




	}

}
