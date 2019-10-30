package com.codebasics.graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BasicDFSGraph {
	
	
	public static void main (String[] args) {
		System.out.println("The DFS traversal of the graph using recursion ");
		BasicDFSGraph main =  new BasicDFSGraph();
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
		
		main.DFSrecursive(node40);
		
		
		System.out.println("The DFS traversal of the graph using stack ");
		node40.visited=false;
		node10.visited=false;
		node20.visited=false;
		node30.visited=false;
		node60.visited=false;
		node50.visited=false;
		node70.visited=false;
		
		main.DFSStack(node40);
		
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> queue = new LinkedList<>();
		queue.poll();
		queue.isEmpty();
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>();
		minHeap.poll();
		LinkedList<Node> lk = new LinkedList<>();
		lk.add(null);
		lk.poll();
	}
	
	//Graph node class
	class Node{
		int data;
		boolean visited;
		public List<Node> neighbours;
		
		Node(int data){
			this.data = data;
			this.neighbours =  new ArrayList<Node>();
		}
	}
	
	public void DFSrecursive(Node node) {
		System.out.println(node.data + " ");
		node.visited = true;
		List<Node> neightbours = node.neighbours;
		for(int i = 0 ;i < neightbours.size(); i++) {
			Node n = neightbours.get(i);
			if(n!= null && !n.visited) {
				DFSrecursive(n);
			}
		}
	}
	
	public void DFSStack(Node node) {
		Stack<Node> stack =  new Stack<Node>();
		stack.add(node);
		while(!stack.isEmpty()) {
			Node n = stack.pop();
			System.out.println(n.data + " ");
			List<Node> neighbours  = n.neighbours;
			for(int i =0 ; i < neighbours.size(); i++) {
				Node neighbour = neighbours.get(i);
				if(neighbour != null && !neighbour.visited) {
					stack.add(neighbour);
					neighbour.visited = true;
				}
			}
		}
		
	}
	
	

}
 