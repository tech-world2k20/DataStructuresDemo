package GraphDS;

import java.util.ArrayList;

public class Graph {
	
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
		adj.get(i).add(j);
		adj.get(j).add(i);
	}
	
	static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print("adjacency list of vertex " + i+":");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" ->"+adj.get(i).get(j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int vertex = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertex);
		for (int i = 0; i < vertex; i++) 
			adj.add(new ArrayList<>());
		
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		
		printGraph(adj);
	}

}
