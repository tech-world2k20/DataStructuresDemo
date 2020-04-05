package stackProblems;

public class findingSpans {
	
	public int[] method(int[] intpArr) {
		int[] spans = new int[intpArr.length];
		for (int i = 0; i < spans.length; i++) {
			int span = 1;
			int j = i-1;
			while (j>=0 && intpArr[j] <= intpArr[j+1]) {
				span++;
				j--;
			}
			spans[i] = span;
		}
		return spans;
	}
	
	
	public static void main(String[] argStrings) {
		
		findingSpans s = new findingSpans();
		long t1 = System.currentTimeMillis();
		int[] res =s.method(new int[] {6,3,4,5,2});
		System.out.println(System.currentTimeMillis() - t1);
		for (int i : res) {
			System.out.print(i +" ");
		}
	}

}
