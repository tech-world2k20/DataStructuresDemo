import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public Solution(){
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) 
			minStack.push(x);
	}


public void pop() {
	if(!stack.isEmpty()) {
		if(stack.peek() == minStack.peek()) 
			minStack.pop();

		stack.pop();

	}
}

public int top() {
	if(stack.isEmpty()) return -1;

	return stack.peek();
}

public int getMin() {
	if(minStack.isEmpty()) return -1;
	return minStack.peek();
}


static int removeDuplicates(ArrayList<Integer> a) {
	if(a.size() < 2)
        return a.size();
    int count=0;
    int size = a.size();
    for(int i=1; i<size; i++){
        
        if((int)a.get(count) != (int)a.get(i)){
            int removedVal = a.remove(i);
            a.add(count+1, removedVal);
           count++;
        }
    }
    
    for(int i=0; i<size-count-1; i++) {
    	a.remove(count+1);
    }
    
    return count+1;
}

public static void insertionSort(int[] ar, int n) {
	int i,j,v;
	for(i=2; i<=n-1; i++) {
		v = ar[i];
		j=i;
		while(j>=1&& ar[j-1]>v ) {
			ar[j] = ar[j-1];
			j--;
		}
		ar[j] = v;
	}
	
	for (int k = 0; k < ar.length; k++) {
		System.out.print(ar[k]+" ");
	}
}

public static void main(String args[]) {
	Solution s =new Solution();

	int[] a = { 19, 'P', 78, 'P', 9, 'g', 'P', 8, 'g', 'P', 7, 'g', 'P', 6, 'g', 'p', 'g', 'p'};
	for (int i = 0; i < a.length; i++) {
		s.push(a[i]);
	}
	//		    	s.push(11);
	//		    	s.push(15);
	//		    	s.push(12);
	//		    	s.push(21);
	//		    	s.push(25);
	//		    	s.push(23);
	//		    	s.push(9);
	//		    	s.push(1);
	//		    	s.push(5);
	//		    	s.push(3);

//	System.out.println(s.top());
//	s.pop();
//	System.out.println(s.top());
//	System.out.println(s.getMin());
	
	Queue<Integer> q = new LinkedList<>();
	
	
	ArrayList<Integer> list = new ArrayList<>();
	list.add(0);
	list.add(0);
	list.add(0);
	list.add(1);
	list.add(1);
	list.add(2);
	list.add(2);
	list.add(3);
	list.add(3);
	list.add(3);
	list.add(3);
	list.add(3);
//	int res =removeDuplicates(list);
//	System.out.println(res);
	
	int[] ar = {6,8,5,4,1,3,7,2};
	insertionSort(ar, ar.length);
}

}
