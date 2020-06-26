package InterviewBit;

public class ReverseNumber_IntegerRange {
	static int reverse(int A) {
	
			if(A >= Integer.MAX_VALUE || A<= Integer.MIN_VALUE)
				return 0;
	
			boolean isNegative=false;
			if(A<0){
				isNegative = true;
				A = -1*A;
			}
			
			long reverseNo=0;
			while(A>0){
				reverseNo  =reverseNo*10 + A%10;
				A /=10;
			}
			System.out.println(reverseNo);
			if(reverseNo > Integer.MAX_VALUE) return 0;
				
			return (int) (isNegative? -reverseNo:reverseNo);
		}
	
	static int reverseIB(int a) {
		String s = a+"";
		
		boolean isNegative=false;
		StringBuilder newString = new StringBuilder(s);
		if(newString.charAt(0) == '-') {
			isNegative = true;
			
			newString.deleteCharAt(0);
		}
		
		Long revNo = Long.parseLong(newString.reverse().toString());
		
		if(revNo > Integer.MAX_VALUE) return 0;
		
		return (int) (isNegative? -revNo:revNo);
	}
	
		public static void main(String[] args) {
	
			//		System.out.println(Integer.MAX_VALUE);
			int a = -1146467285;
	
//			int res = reverse(a);
			int res = reverseIB(a);
			System.out.println(res);
	
		}
}

