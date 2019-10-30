package com.codechallenge;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * There are N cities numbered from 1 to N.

	You are given connections, where each connections[i] = [city1, city2, cost] 
	represents the cost to connect city1 and city2together. (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
	
	Return the minimum cost so that for every pair of cities,
	 there exists a path of connections (possibly of length 1) that connects those two cities together.
	  The cost is the sum of the connection costs used. If the task is impossible, return -1.
	
	Example 1:
	
	Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
	Output: 6
	Explanation:
	Choosing any 2 edges will connect all cities so we choose the minimum 2.
	
	Example 2:
	
	Input: N = 4, connections = [[1,2,3],[3,4,4]]
	Output: -1
	Explanation:
	There is no way to connect all cities even if all edges are used.
	Note:
	
	1 <= N <= 10000
	1 <= connections.length <= 10000
	1 <= connections[i][0], connections[i][1] <= N
	0 <= connections[i][2] <= 10^5
	connections[i][0] != connections[i][1]
	
	
	Solution:
	Try to connect cities with minimum cost, then find small cost edge first, if two cities connected by the edge do no have same ancestor, then union them.
	When number of unions equal to 1, all cities are connected.
	Time Complexity: O(mlogm + mlogN). sort takes O(mlogm). find takes O(logN). With path compression and unino by weight, amatorize O(1).
	Space: O(N).
 * 
 * @author freddy
 *
 */
public class MinCostToAddNewRoads {

	 
	 public static void main(String[] args) {
	        int numCities = 3;
	        int[][] roads = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
	        System.out.println(getMinCostToConstruct(numCities, roads));
	        numCities = 4;
	        int[][] roads1 = {{1, 2, 3}, {3,4, 4}};
	        System.out.println(getMinCostToConstruct(numCities, roads1));
	        
	    }
	    
	    public static int getMinCostToConstruct(int numCities,  int[][] newRoads) {
	    	if(newRoads == null || newRoads.length<=0|| newRoads.length <(numCities-1)){
	    		return -1;
	    	}
	    	Set<Edge> edges = new HashSet<>();
	    	for (int[] road : newRoads) {
	            edges.add(new Edge(road[0], road[1], road[2]));
	        }
	        return kruskalMST(numCities, edges);
	    }

	    private static int kruskalMST(int numCities, Set<Edge> edges) {
	    	//使用优先级队列接队列实现排序
	        Queue<Edge> pq = new PriorityQueue<>(edges);
	        UF uf = new UF(numCities + 1);
	        int mstSize = 0;
	        int totalCost = 0;
	        while (!pq.isEmpty() && mstSize < numCities - 1) {
	            Edge edge = pq.poll();

	            if (!uf.InSameSet(edge.u, edge.v)) {
	                uf.union(edge.u, edge.v);
	                totalCost += edge.cost;
	                mstSize++;
	            }

	        }
	        return totalCost;
	    }
	}


	class Edge implements Comparable<Edge> {
	    int v;
	    int u;
	    int cost;

	    public Edge(int v, int u, int cost) {
	        this.v = v;
	        this.u = u;
	        this.cost = cost;
	    }

	    @Override
	    public int compareTo(Edge that) {
	        return Integer.compare(this.cost, that.cost);
	    }
	}

	class UF {
	    private int[] parent;  // parent[i] = parent of i
	    private byte[] rank;   // rank[i] = rank of subtree rooted at i
       
	    public UF(int n) {
	        if (n < 0) throw new IllegalArgumentException();
	        parent = new int[n];
	        rank = new byte[n];
	        for (int i = 0; i < n; i++) {
	            parent[i] = i;
	        }
	    }

	    public int find(int p) {
	        while (p!=parent[p] ) {
	            p = parent[p];
	        }
	        return p;
	    }
	    public void union(int p, int q) {
	        int pr = find(p);
	        int qr = find(q);
	        if (pr == qr) return;
	        if (rank[pr] < rank[qr]) {
	            parent[pr] = qr;
	        } else {
	            parent[qr] = pr;
	            if (rank[pr] == rank[qr]) rank[pr]++;
	        }
	    }
	    public boolean InSameSet(int p, int q) {
	        return find(p) == find(q);
	    }

}
