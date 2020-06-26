package GraphDS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex{
	public char label;
	public boolean visited;
	public Vertex(char label) {
		this.label = label;
		this.visited = false;
	}
}

class Graph1{
	private final int maxVerteices = 20;
	private Vertex[] vertexList;
	private int[][] adjMatrix;
	private int vertexCount;
	private Stack<Integer> stack;
	private Queue<Integer> queue;
	public Graph1() {
		vertexList = new Vertex[maxVerteices];
		adjMatrix = new int[maxVerteices][maxVerteices];
		vertexCount = 0;
		for (int i = 0; i < maxVerteices; i++) 
			for (int j = 0; j < maxVerteices; j++)
				adjMatrix[j][i] = 0;

		stack = new Stack<>();
		queue = new LinkedList<>();
	}

	public void addVertex(char label) {
		vertexList[vertexCount++] = new Vertex(label);
	}

	public void addEdge(int start, int end) {
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.println(vertexList[v].label);
	}

	public void dfs() {
		
		vertexList[0].visited = true;
		displayVertex(0);
		stack.push(0);
		while (!stack.isEmpty()) {
			int v = getAdjUnvisitedVertex(stack.peek());
			if(v == -1)
				stack.pop();
			
			else {
				vertexList[v].visited = true;
				displayVertex(v);
				stack.push(v);
			}
		}
		for (int i = 0; i < vertexCount; i++) {
			vertexList[i].visited = false;
		}
	}
	
	public void bfs() {
		vertexList[0].visited = true;
		displayVertex(0);
		queue.add(0);
		int v2;
		
		while (!queue.isEmpty()) {
			int v1 = queue.poll();
			while ((v2=getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].visited = true;
				displayVertex(v2);
				queue.add(v2);
			}
		}
		for (int i = 0; i < vertexCount; i++) {
			vertexList[i].visited = false;
		}
	}

	private int getAdjUnvisitedVertex(int v) {
		
		for (int i = 0; i < vertexCount; i++) {
			if(adjMatrix[v][i] ==1 && vertexList[i].visited == false)
				return i;
		}
		return -1;
	}

}

public class DFSandBFS {

	public static void main(String[] args) {
		Graph1 graph = new Graph1();
		graph.addVertex('A');
		graph.addVertex('B');
		
	
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 1);
		graph.addEdge(1, 4);
//		graph.bfs();
		graph.dfs();
		
	}

}
