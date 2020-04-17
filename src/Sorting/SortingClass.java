package Sorting;

import java.util.Collections;
import java.util.PriorityQueue;

public class SortingClass {
	int[] dummyArr;
	
	public void BubbleSort(int[] arr) {
		dummyArr = arr;
		for (int i = dummyArr.length-1; i >=0; i--) 
			for (int j = 0; j < i; j++) {
				if(dummyArr[j] > dummyArr[j+1])
					swap(dummyArr, j, j+1);
			}
	}

	public static void swap(int[] dummyArr, int i, int j) {
		if(i==j) return;

		int temp = dummyArr[i];
		dummyArr[i]= dummyArr[j];
		dummyArr[j] = temp;
	}
	
	public void SelectionSort(int[] arr) {
		dummyArr = arr;
		for (int i = 0; i < dummyArr.length-1; i++) {
			int min=i, j;
			for (j = i+1; j < dummyArr.length; j++) 
				if(dummyArr[j] < dummyArr[min]) min =j;
			
			swap(dummyArr, min, i);
		}
	
	}
	
	public  void printArray() {
		for (int i : dummyArr) 
			System.out.print(i +" ");
		
		System.out.println();
	}
	
	public void InsertionSort(int[] arr) {
		dummyArr = arr;
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < dummyArr.length; firstUnsortedIndex++) {
			int newElement = dummyArr[firstUnsortedIndex];
			int i;
			for(i=firstUnsortedIndex; i>0 && dummyArr[i-1] > newElement; i--) {
				dummyArr[i] = dummyArr[i-1];
			}
			dummyArr[i] = newElement;
		}
	}
	
	// 5 9 -2 4 0 -67 4 98 -1 
	public void ShellSort(int[] arr) {
		dummyArr = arr;
		for(int gap= dummyArr.length/2; gap>0; gap /=2) {
			
			for (int i = gap; i < dummyArr.length; i++) {
				int newElement = dummyArr[i];
				int j=i;
				
				while (j>=gap && dummyArr[j-gap]>newElement) {
					dummyArr[j] = dummyArr[j-gap];
					j -=gap;
				}
				
				dummyArr[j] = newElement;
			}
		}
	}

	
	public void MergeSort(int[] arr, int start, int end) {
		dummyArr = arr;
		if(end-start < 2) return;
		
		int mid = (start+end)/2;
		MergeSort(dummyArr, start, mid);
		MergeSort(dummyArr, mid, end);
		Merge(dummyArr, start, mid, end);
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
	
	public  void QuickSort(int[] arr, int start, int end) {
		dummyArr = arr;
		if(end-start < 2) return;
		
		int pivotIndex = partion(dummyArr, start, end);
		QuickSort(arr, start, pivotIndex);
		QuickSort(arr, pivotIndex+1, end);
		
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
	
	public void CountingSort(int[] arr, int min, int max) {
		dummyArr = new int[max-min+1];
		for (int i = 0; i < arr.length; i++) 
			dummyArr[arr[i]-min]++;
		
		int j=0;
		for (int i = min; i <=max; i++) {
			while (dummyArr[i-min] >0) {   // you can directly decrement the value here only
				arr[j++] = i;
				dummyArr[i-min]--; 		//instead of doing separately here
			}
		}
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	
	

	public static void main(String args[]) {
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
		// min -2, max=98
		System.out.print("Final Array(CountingSort) :   ");
		b.CountingSort(arr1, 1, 10);
		
		
	}

	
}	
