import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

// tutorial: https://www.youtube.com/watch?v=zLZhSSXAwxI

public class Main {
	
	// graph (adjacency list representation)
	static int[][] G = {{0, 1, 0, 1, 0, 0, 1, 0},
						{1, 0, 0, 0, 1, 1, 0, 0},
						{0, 0, 0, 0, 0, 1, 0, 1},
						{1, 0, 0, 0, 0, 1, 0, 0},
						{0, 1, 0, 0, 0, 0, 1, 0},
						{0, 1, 1, 1, 0, 0, 0, 0},
						{1, 0, 0, 0, 1, 0, 0, 0},
						{0, 0, 1, 0, 0, 0, 0, 0}};

	public static void main(String[] args) {
		int root = 0;
		
		System.out.println("depth-first traversal from node index "+root);
		dft(root);
		
		System.out.println("bredth-first traversal from node index "+root);
		bft(root);
	}
	
	// depth-first traversal
	static void dft(int root) {
		Stack<Integer> s = new Stack<Integer>();
		int l = G.length;
		int[] visited = new int[l];
		
		s.push(new Integer(root));
		visited[root] = 1;
		System.out.println(root);
		
		while(!s.isEmpty()) {
			int i = s.peek();
			int j;
			for(j = 0; j < l; j++) {
				if (G[i][j] == 1 && visited[j] == 0) {
					break;
				}
			}
			if (j < l) { // there's a connected node not visited
				s.push(new Integer(j));
				visited[j] = 1;
				System.out.println(j);
			} else {
				s.pop();
			}
		}
	}
	
	// breadth-first traversal
	static void bft(int root) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		int l = G.length;
		int[] visited = new int[l];
		
		q.add(new Integer(root));
		visited[root] = 1;
		System.out.println(root);
		
		while(!q.isEmpty()) {
			int i = q.remove();
			
			for (int j = 0; j < l; j++) {
				if (G[i][j] == 1 && visited[j] == 0) {
					q.add(new Integer(j));
					System.out.println(j);
					visited[j] = 1;
				}
			}
		}
	}
	
}
