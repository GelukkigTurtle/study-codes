package com.codechallenge;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Given a data center with n servers from 1 to n. To make the data center running, all servers must be connected, that means there exists at least one path between any pair of servers. Now we know there could be some cirtical connections broken which brings down the whole data center. You need to write a program to find out all these broken cirtical connections. A server connection is a cirtical connection which when removed will make the whole data center disconnected.
	Write a method to output all critical connections.
	
	Input:
	serversNum, the number of servers in the data center.
	connectionsNum, the number of connections between the servers.
	connections, a list of pairs reperesting the connections between two severs.
	
	Output:
	Return a list of integer pairs representing the cirtical connections. Output an empty array if there are no cirtical connections.
	Example :
	Input:
	serversNum = 4
	connectionsNum = 4
	connections = [[1, 2], [1, 3], [3, 2], [3, 4]]
	
	Output:
	[[3,4]]
	Explanation:
	There are one cirtical connections:
	1. Between server 3 and 4
	If the connection [3, 4] breaks, then the network will be disconnected since servers 3 and 4 cannot communicate with the rest of the network.
	Remaining three connections are not cirtical.
 * @author freddy
 *
 */
public class DataCenterCirticalConnections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int n=4;
	        int[][] edges = {{1, 2}, {1, 3}, {3, 2}, {3, 4}};
	        int[][] ans = bridges(edges,n);
	        if(ans.length==0)
	            System.out.print("[]");
	        for(int[] arr : ans)
	            System.out.print(Arrays.toString(arr)+",");
	       
	}
	   static int time = 0;
	    static final int NIL = -1;
	    static List<Integer[]> ans1 = new LinkedList<>();
	    
	    static class Graph{
	        private int v;
	        private LinkedList<Integer> adj[]; 
	        Graph(int V) 
	        { 
	            v = V; 
	            adj = new LinkedList[V+1]; 
	            for (int i=0; i<V+1; ++i) 
	                adj[i] = new LinkedList(); 
	        }
	        
	        void addEdge(int V, int w) 
	        { 
	            this.adj[V].add(w);
	            this.adj[w].add(V);
	        }
	    }
	    
	    static void bridgeDfs(Graph g,int u,boolean visited[], int disc[], int low[], int parent[] )
	    {
	        visited[u] = true;
	        disc[u]=low[u]=++time;
	        
	        Iterator<Integer> i = (g.adj[u]).iterator();
	        while(i.hasNext())
	        {
	            int v = i.next();
	            if(!visited[v])
	            {
	                parent[v]=u;
	                bridgeDfs(g,v,visited,disc,low,parent);
	                low[u] = Math.min(low[u],low[v]);
	                if(low[v]>disc[u])
	                    ans1.add(new Integer[]{u,v});
	            }
	            else if(v!=parent[u])
	            {
	                low[u] = Math.min(low[u],disc[v]);
	            }
	        }
	    }
	    
	    static int[][] bridges(int[][] edges,int v)
	    {
	        Graph g = new Graph(v);
	        for(int i=0;i<edges.length;i++)
	        {
	            g.addEdge(edges[i][0],edges[i][1]);
	        }
	        boolean visited[] = new boolean[v+1];
	        int disc[] = new int[v+1];
	        int low[] = new int[v+1];
	        int parent[] = new int[v+1];
	        
	        for(int i=0;i<v;i++)
	        {
	            parent[i]=NIL;
	            visited[i]=false;
	        }
	        

	        for(int i=0;i<v;i++)
	        {
	            if(!visited[i])
	            {
	                bridgeDfs(g,i, visited, disc, low, parent);
	            }
	        }
	        
	        int[][] res = new int[ans1.size()][2];
	        int index=0;
	        for(Integer[] temp: ans1)
	        {
	            res[index][0]=temp[0];
	            res[index][1]=temp[1];
	            index++;
	        }
	        return res;
	    }

}

/*class Solutions {
    // We record the timestamp that we visit each node. For each node, we check every neighbor except its parent and return a smallest timestamp in all its neighbors. If this timestamp is strictly less than the node's timestamp, we know that this node is somehow in a cycle. Otherwise, this edge from the parent to this node is a critical connection
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(List<Integer> oneConnection :connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        int timer[] = new int[1];
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int []timeStampAtThatNode = new int[n]; 
        criticalConnectionsUtil(graph, -1, 0, timer, visited, results, timeStampAtThatNode);
        return results;
    }
    
    
    public void criticalConnectionsUtil(List<Integer>[] graph, int parent, int node, int timer[], boolean[] visited, List<List<Integer>> results, int []timeStampAtThatNode) {
        visited[node] = true;
        timeStampAtThatNode[node] = timer[0]++;
        int currentTimeStamp = timeStampAtThatNode[node];
        
        for(int oneNeighbour : graph[node]) {
            if(oneNeighbour == parent) continue;
            if(!visited[oneNeighbour]) criticalConnectionsUtil(graph, node, oneNeighbour, timer, visited, results, timeStampAtThatNode);
            timeStampAtThatNode[node] = Math.min(timeStampAtThatNode[node], timeStampAtThatNode[oneNeighbour]);
            if(currentTimeStamp < timeStampAtThatNode[oneNeighbour]) results.add(Arrays.asList(node, oneNeighbour));
        }
        
        
    }
    
}*/
