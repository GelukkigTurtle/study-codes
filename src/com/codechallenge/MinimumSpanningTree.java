package com.codechallenge;
import java.util.Arrays;

/*
 * Given an undirected graph with n nodes labeled 1..n. Some of the nodes are already connected.
 *  The i-th edge connects nodes edges[i][0] and edges[i][1] together. 
 *  Your task is to augment this set of edges with additional edges to connect all the nodes. 
 *  Find the minimum cost to add new edges between the nodes such that all the nodes are accessible from each other.

	Input:
	n, an int representing the total number of nodes.
	edges, a list of integer pair representing the nodes already connected by an edge.
	newEdges, a list where each element is a triplet representing the pair of nodes between which an edge can be added and the cost of addition,
	 respectively (e.g. [1, 2, 5] means to add an edge between node 1 and 2, the cost would be 5).
	
	Example:
	Input:
	n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
	Output: 7
	Explanation:
	There are 3 connected components [1, 4, 5], [2, 3] and [6].
	We can connect these components into a single component by connecting node 1 to node 2 and node 1 to node 6 at a minimum cost of 5 + 2 = 7.
	
	hint: what’s the time complexity of your algorithm? Can you make the running time O(E * log(E)) by using Union Find?
 */
public class MinimumSpanningTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    MinimumSpanningTree main=new MinimumSpanningTree();
        int tc1=main.minCosttoConnectAllNodes(6, new int[][]{{1, 4}, {4, 5}, {2, 3}}, new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}});
        if(tc1==7) {
        	System.out.println(tc1);
            System.out.println("All Test Case Pases!");
        } else {
            System.out.println("There are test failures!");
        }

	}
	    int[] parent;
	    int component;
	    
	    private int find(int v){
	        if(parent[v] == v) return v;
	        return parent[v] = find(parent[v]);
	    }
	    
	    private void connect(int v1, int v2){
	        if(find(v1) == find(v2)) return;
	        int root = find(v1);
	        while(v2 != parent[v2]){
	            int temp = parent[v2];
	            parent[v2] = root;
	            v2 = temp;
	        }
	        --component;
	        parent[v2] = root;
	    }
	    
	    private boolean isConnected(int v1, int v2){
	        return find(v1) == find(v2);
	    }
	    
	    public int minCosttoConnectAllNodes(int n, int edges[][], int newEdges[][]){
	        parent = new int[n + 1]; component = n;
	        for(int i = 0; i <= n; ++i) parent[i] = i;
	        for(int[] edge: edges) connect(edge[0], edge[1]);
	        Arrays.sort(newEdges, (a, b) -> (a[2] - b[2]));
	        int cost = 0;
	        for(int i = 0; i < newEdges.length; ++i){
	            if(!isConnected(newEdges[i][0], newEdges[i][1])){
	                connect(newEdges[i][0], newEdges[i][1]);
	                cost += newEdges[i][2];
	                if(component == 1) return cost;
	            }
	        }
	        return -1;
	    }

}
