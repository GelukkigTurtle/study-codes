package com.codebasics.graphs;
import java.util.LinkedList;
import java.util.Iterator;

public class DeepFirstSearchGraph {
	//Doing traversal graph DFS by all conected vertex

	public static void main(String[] args) {
		DeepFirstSearchGraph  main = new DeepFirstSearchGraph();
		Graph g = main.new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		int vertexToBegin = 2;
		System.out.println("Doing DFS starting from vertex: "+vertexToBegin);
		g.DFS(vertexToBegin);
	}
	
	class Graph{
		//fields
		private int number_of_vertices;
		private LinkedList<Integer> adj[];
		//constructor
		Graph(int v){
			this.number_of_vertices = v;
			adj = new LinkedList[v];
			for(int i = 0; i < number_of_vertices ;i++) {
				adj[i] = new LinkedList<>();
			}
			
		}
		
		//add method
		void addEdge(int v, int w) {
			adj[v].add(w);
		}
		
		void DFSUtil(int v, boolean visited[]) {
			//mark the current node as visited and print it
			visited[v] = true;
			System.out.println(v +" ");
			
			//Recur all the vertices adjacents to this vertex
			Iterator<Integer> i = adj[v].listIterator();
			while(i.hasNext()) {
				int node = i.next();
				if(!visited[node]) {
					DFSUtil(node, visited);
				}
			}
		}
		
		void DFS(int v) {
			//in java all boolean is set as false by default
			boolean visited[] = new boolean[number_of_vertices];
			
			//in case that the vertex are not connected, I need to make DFS for all
			//available vertex and checking before if they are not visited
			for(int i = 0 ; i < number_of_vertices; i++) {
				if(visited[i] == false)
					DFSUtil(v, visited);
			}
		}
			
	}
	

}
