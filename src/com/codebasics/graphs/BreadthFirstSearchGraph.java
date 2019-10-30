package com.codebasics.graphs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

public class BreadthFirstSearchGraph {
	
	public static void main(String[] args) {
		BreadthFirstSearchGraph  main = new BreadthFirstSearchGraph();
		Graph g = main.new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		int vertexToBegin = 2;
		System.out.println("Doing BFS starting from vertex: "+vertexToBegin);
		g.BFS(vertexToBegin);
	}
	
		
	class Graph{
		private int number_of_vertex;
		private LinkedList<Integer> adj[];
		Graph(int v){
			this.number_of_vertex = v;
			adj = new LinkedList[number_of_vertex];
			for(int i = 0; i < number_of_vertex; i++) {
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int v, int value) {
			adj[v].add(value);
		}
		
		void BFS(int source) {
			//mark all vertices as non visited
			boolean visited[] = new boolean[number_of_vertex];
			//createing the queue
			Queue<Integer> queue = new LinkedList<>();
			//mark current node as visited and add to the queue
			visited[source] = true;
			queue.add(source);
			
			while(queue.size() != 0){
				//deque and print
				source = queue.poll();
				System.out.println(source + " ");
				
				//iterate adjacent vertex from current value and mark them as visited and add to the queue
				Iterator<Integer> i =  adj[source].listIterator();
				while(i.hasNext()) {
					int n = i.next();
					if(!visited[n]) {
						visited[n] = true;
						queue.add(n);
					}
				}
				
			}
		}
		
	}

}
