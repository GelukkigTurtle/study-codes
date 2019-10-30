package com.codebasics.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneUndirGraph {

	public static void main(String[] args) {
	        Node source = buildGraph(); 
	        System.out.println("BFS traversal of a graph before cloning"); 
	        bfs(source); 
	        Node newSource = cloneGraph(source); 
	        System.out.println("BFS traversal of a graph after cloning"); 
	        bfs(newSource); 

	}
	
	static class Node{
		int val;
		List<Node> neighbors;
		Node(int data, List<Node> n){
			this.val  = data;
			this.neighbors = n;
		}
	}
	
	 public static  void traverseGraph(Node node, Map<Node,Node> copy){
	        if (copy.containsKey(node)) return;
	        else{
	            Node copyNode = new Node(node.val,null);
	            copy.put(node,copyNode);
	            List<Node> copyNeighbors = new ArrayList<>();
	            for(Node n : node.neighbors){
	                traverseGraph(n,copy);
	                copyNeighbors.add(copy.get(n));
	            }
	            copyNode.neighbors = copyNeighbors;
	        }
	    }
	    
	    public static Node cloneGraph(Node node) {
	        Map<Node,Node> copy = new HashMap<>();
	        traverseGraph(node,copy);
	        return copy.get(node);
	    }
	
	
	
	// Build the desired graph 
    static public Node buildGraph() { 
        /* 
            Note : All the edges are Undirected 
            Given Graph: 
            1--2 
            |  | 
            4--3 
        */
    	Node node1 = new Node(1,null); 
    	Node node2 = new Node(2,null); 
    	Node node3 = new Node(3,null); 
    	Node node4 = new Node(4,null); 
    	ArrayList<Node> v = new ArrayList<Node>(); 
        v.add(node2); 
        v.add(node4); 
        node1.neighbors = v; 
        v = new ArrayList<Node>(); 
        v.add(node1); 
        v.add(node3); 
        node2.neighbors = v; 
        v = new ArrayList<Node>(); 
        v.add(node2); 
        v.add(node4); 
        node3.neighbors = v; 
        v = new ArrayList<Node>(); 
        v.add(node3); 
        v.add(node1); 
        node4.neighbors = v; 
        return node1; 
    } 
    
    // BFS traversal of a graph to 
    // check if the cloned graph is correct 
    static void bfs(Node source) { 
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(source); 
        HashMap<Node,Boolean> visit = 
                          new HashMap<Node,Boolean>(); 
        visit.put(source,true); 
        while (!q.isEmpty()) 
        { 
        	Node u = q.poll(); 
            System.out.println("Value of Node " + u.val); 
            System.out.println("Address of Node " + u); 
            if (u.neighbors != null) 
            { 
                List<Node> v = u.neighbors; 
                for (Node g : v) 
                { 
                    if (visit.get(g) == null) 
                    { 
                        q.add(g); 
                        visit.put(g,true); 
                    } 
                } 
            } 
        } 
        System.out.println(); 
    }

}
