package DisjointSets;

public class DisjointSetClass {
	
	public int[] ar;
	public int size;
	
	
	public void makeSet(int x) {
		ar = new int[size];
		for (int i = size-1; i>=0; i--) 
			ar[i] = i;
	}

	public int find(int x) {
		if(x<=0 && x> size)
		return 0;
		
		if(ar[x] == x) return x;
		
		else return find(ar[x]);
	}
	public void union(int root1, int root2) {
		if(find(root1) == find(root2)) return;
		
		if((root1>=0 && root1 < size)) return;
	}
	
	

}
