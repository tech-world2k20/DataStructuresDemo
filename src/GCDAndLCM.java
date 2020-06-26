import java.io.IOException;
import java.util.Scanner;

public class GCDAndLCM {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while(n-- > 0) {
			int x = s.nextInt();
			int y = s.nextInt();
			
			int gcd = GCDMethod(x,y);
			int lcm = x*y/gcd;
			
			System.out.println(gcd+" "+lcm);
		}
		
		s.close();
		

	}

	private static int GCDMethod(int x, int y) {
		if(y > x)
			return GCDMethod(y, x);
		
		if(y == 0)
				return x;
		
		return GCDMethod(y, x%y);
	}

}
