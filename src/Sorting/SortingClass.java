package Sorting;

import java.util.Collections;
import java.util.PriorityQueue;

import BinaryTree.BinaryTree;
import Heap.HeapClass;

public class SortingClass {
	int[] countArr;


	public int[] BubbleSort(int[] arr) {
		countArr = arr;
		for (int i = countArr.length-1; i >=0; i--) 
			for (int j = 0; j < i; j++) {
				if(countArr[j] > countArr[j+1])
					swap(countArr, j, j+1);
			}
		
		return countArr;
	}

	public static void swap(int[] dummyArr, int i, int j) {
		if(i==j) return;

		int temp = dummyArr[i];
		dummyArr[i]= dummyArr[j];
		dummyArr[j] = temp;
	}

	public int[] SelectionSort(int[] arr) {
		countArr = arr;
		for (int i = 0; i < countArr.length-1; i++) {
			int min=i, j;
			for (j = i+1; j < countArr.length; j++) 
				if(countArr[j] < countArr[min]) min =j;

			swap(countArr, min, i);
		}
		return countArr;
	}

	public  void printArray() {
		for (int i : countArr) 
			System.out.print(i +" ");

		System.out.println();
	}

	public int[] InsertionSort(int[] arr) {
		countArr = arr;
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < countArr.length; firstUnsortedIndex++) {
			int newElement = countArr[firstUnsortedIndex];
			int i;
			for(i=firstUnsortedIndex; i>0 && countArr[i-1] > newElement; i--) {
				countArr[i] = countArr[i-1];
			}
			countArr[i] = newElement;
		}
		
		return countArr;
	}

	// 5 9 -2 4 0 -67 4 98 -1 
	public int[] ShellSort(int[] arr) {
		countArr = arr;
		for(int gap= countArr.length/2; gap>0; gap /=2) {

			for (int i = gap; i < countArr.length; i++) {
				int newElement = countArr[i];
				int j=i;

				while (j>=gap && countArr[j-gap]>newElement) {
					countArr[j] = countArr[j-gap];
					j -=gap;
				}

				countArr[j] = newElement;
			}
		}
		return countArr;
	}


	public int[] MergeSort(int[] arr, int start, int end) {
		countArr = arr;
		if(end-start < 2) return null;

		int mid = (start+end)/2;
		MergeSort(countArr, start, mid);
		MergeSort(countArr, mid, end);
		Merge(countArr, start, mid, end);
		
		return countArr;
	}

	private void Merge(int[] arr, int start, int mid, int end) {
		if(arr[mid-1] <= arr[mid]) return;

		int i= start;
		int j= mid;
		int tempIndex=0;

		int[] temp = new int[end-start];

		while (i< mid && j<end) 
			temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

			System.arraycopy(arr, i, arr, start+tempIndex, mid-i);
			System.arraycopy(temp, 0, arr, start, tempIndex);

			temp = null;
	}

	public  int[] QuickSort(int[] arr, int start, int end) {
		countArr = arr;
		if(end-start < 2) return null;

		int pivotIndex = partion(countArr, start, end);
		QuickSort(arr, start, pivotIndex);
		QuickSort(arr, pivotIndex+1, end);
		
		return countArr;

	}

	private int partion(int[] dummyArr, int start, int end) {

		int pivot = dummyArr[start];
		int i= start;
		int j= end;

		while (i<j) {
			//empty loop body
			while (i<j && dummyArr[--j] >= pivot);

			if(i<j) 
				dummyArr[i] = dummyArr[j];

			//empty loop body	
			while (i<j && dummyArr[++i] <= pivot);

			if(i<j)
				dummyArr[j] = dummyArr[i];

		}
		dummyArr[j] = pivot;
		return j;
	}

	//not a in-place algorithm
	public int[] CountingSort(int[] arr, int min, int max) {
		countArr = new int[max-min+1];
		for (int i = 0; i < arr.length; i++) 
			countArr[arr[i]-min]++;

		int j=0;
		for (int i = min; i <=max; i++) {
			while (countArr[i-min] >0) {   // you can directly decrement the value here only
				arr[j++] = i;
				countArr[i-min]--; 		//instead of doing separately here
			}
		}
//		for (int i : arr) 
//			System.out.print(i+" ");
		
		return arr;
	}


	public int[] CountingSortInPlace(int[] arr, int min,int max) {
		int[] b = new int[arr.length];

		countArr = new int[max-min+1];
		for (int i = 0; i < arr.length; i++) 
			countArr[arr[i]-min]++;

		for (int i = 1; i < countArr.length; i++) 
			countArr[i] += countArr[i-1]; 

		for (int i = arr.length-1; i >=0; i--) 	
			b[--countArr[arr[i]-min]] = arr[i];

//		for (int i : b) 
//			System.out.print(i+" ");
		
		return b;
	}

	public void HeapSort(int[] arr1) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		System.out.print("Final Array(HeapSort) :	      ");
		for (int i = 0; i < arr1.length; i++) 
			minHeap.add(arr1[i]);

		while (!minHeap.isEmpty()) 
			System.out.print(minHeap.poll()+" ");
	}

	public void TreeSort(int[] arr1) {
		BinaryTree bt = new BinaryTree();
		System.out.print("Final Array(TreeSort) :	     ");
		for (int i : arr1) 
			bt.insert(i);
		
		bt.inOrderTraversal();
	}

/*	public static void main(String args[]) {
		SortingClass b = new SortingClass();
		int arr[] = {5,9,-2,4,0,-67,4,98,-1};
		System.out.print("initial array : 	      ");
		for (int i : arr) {
			System.out.print(i+" ");
		}

		System.out.println();

		//		b.BubbleSort(arr);
		//		System.out.println();
		//		System.out.print("final array(bubbleSort) :    ");
		//		for (int i : res) 
		//			System.out.print(i +" ");

		//		b.SelectionSort(arr);
		//		System.out.println();
		//		System.out.print("final array(selectionSort) : ");
		//		b.printArray();

		//		b.InsertionSort(arr);
		//		System.out.print("Final Array(InsertionSort) : ");
		//		b.printArray();

		//		b.ShellSort(arr);
		//		System.out.print("Final Array(ShellnSort) : ");
		//		b.printArray();

		//		b.MergeSort(arr, 0, arr.length);
		//		System.out.print("Final Array(MergeSort) :     ");
		//		b.printArray();

		//		b.QuickSort(arr, 0, arr.length);
		//		System.out.print("Final Array(QuickSort) :     ");
		//		b.printArray();

		int[] arr1 = {2,5,9,8,2,8,7,10,4,3};
		System.out.print("Initial Array : 		");
		for (int i : arr1) 
			System.out.print(i+" ");
		System.out.println();
		
		// min 1, max=10
		//		System.out.print("Final Array(CountingSort) :   ");
		//		b.CountingSort(arr1, 1, 10);

		//		b.CountingSortInPlace(arr1, 1, 10);

//			b.HeapSort(arr1);
		
		b.TreeSort(arr);



	}
*/

}	
