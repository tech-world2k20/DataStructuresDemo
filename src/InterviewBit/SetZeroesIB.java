package InterviewBit;

import java.util.ArrayList;

public class SetZeroesIB {


	static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		int m = a.size();
		int n = a.get(0).size();
		ArrayList<Integer> ithList;
		ArrayList<Integer> row = new ArrayList<>();
		boolean[] colToBe0 = new boolean[n];
		for(int i=0; i<n; i++) {
			row.add(0);
			colToBe0[i] = false;
		}
		boolean isZeroInEntireRow=false;
		for(int i=0; i<m; i++) {
			 ithList = a.get(i);
			for (int j = 0; j < n; j++) {
				if(ithList.get(j) == 0) {
					colToBe0[j] = true;
					isZeroInEntireRow = true;
				}

			}
			if(isZeroInEntireRow) {
				a.set(i, row);
				isZeroInEntireRow = false;
			}
				
				
		}
		
		for(int i=0; i<n; i++) {
			if(colToBe0[i] == true) {
				for(int j=0; j<m; j++) {
					a.get(j).set(i, 0);
				}
			}
		}

	}
	
	// solution given on IB
	public void setZeroesIB(ArrayList<ArrayList<Integer>> a) {
	       int m=a.size();
	       int n=a.get(0).size();
	       boolean row[] = new boolean[a.size()];
	       boolean col[] = new boolean[a.get(0).size()];
	      for(int i=0;i<m;i++){
	          for(int j=0;j<n;j++){
	              if(a.get(i).get(j)==0){
	                  row[i]=true;
	                  col[j]=true;
	              }
	          }
	      }
	      for(int i=0;i<m;i++){
	          for(int j=0;j<n;j++){
	            if(row[i]||col[j]) a.get(i).set(j,0);
	        }
	      }
	}
	
	public static void main(String args[]) {
		int m=2,n=2;
		ArrayList<ArrayList<Integer>> list= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> ithList = new ArrayList<Integer>();
		ArrayList<Integer> jthlist = new ArrayList<Integer>();
		ithList.add(0);
		ithList.add(1);
		jthlist.add(1);
		jthlist.add(1);
		list.add(ithList);
		list.add(jthlist);
		
		
		setZeroes(list);
	}
}

