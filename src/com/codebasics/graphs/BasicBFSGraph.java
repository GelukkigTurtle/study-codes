 package com.codebasics.graphs;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BasicBFSGraph {
	
	public static void main (String[] arg) {
		BasicBFSGraph main = new BasicBFSGraph();
		Node node40 = main.new Node(40);
		Node node10 = main.new Node(10);
		Node node20 = main.new Node(20);
		Node node30 = main.new Node(30);
		Node node60 = main.new Node(60);
		Node node50 = main.new Node(50);
		Node node70 = main.new Node(70);
 
		node40.neighbours.add(node10);
		node40.neighbours.add(node20);
		node10.neighbours.add(node30);
		node20.neighbours.add(node10);
		node20.neighbours.add(node30);
		node20.neighbours.add(node60);
		node20.neighbours.add(node50);
		node30.neighbours.add(node60);
		node60.neighbours.add(node70);
		node50.neighbours.add(node70);
		System.out.println("The BFS traversal of the graph is ");
		
		main.BFS(node40);
	}
	
	class Node{
		int data;
		boolean visited;
		List<Node> neighbours;
		Node(int data){
			this.data = data;
			neighbours = new ArrayList<Node>();
		}
	}
	
	public void BFS(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node !=null) {
				System.out.println(node.data + " ");
				List<Node> neighbours = node.neighbours;
				for(Node n : neighbours) {
					if(n != null && !n.visited) {
						q.add(n);
						n.visited = true;
					}
				}
			}
		}
	}

}
