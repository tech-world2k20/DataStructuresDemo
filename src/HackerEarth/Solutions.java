package HackerEarth;

public class Solutions {
	
	static <x> x method(x value) {
		return value;
	}

	public static void main(String[] args) {
		int[] ar = {3,5,5,5,5,5,5,7,7,7,7,7,3,3,3,7,3};
		int res=ar[0];
		for (int i=1; i<ar.length; i++) 
			res ^=ar[i];
		
		System.out.println(res);


	}

}
