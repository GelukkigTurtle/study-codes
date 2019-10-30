package com.codechallenge;
import java.util.ArrayDeque;
import java.util.Queue;
/**
 
  You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
	There are other explorers trying to find the treasure. So you must figure out a shortest route to one of the treasure island.
	Assume the map area is a two dimensional grid, represented by a matrix of characters.
	You must start from one of the starting point(marked as 'S') of the map and can move one block up, down, left or right at a time.
	The treasure island is marked as ‘X’ in a block of the matrix.
	Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
	Other areas ‘O’ are safe to sail in.
	Output the minimum number of steps to get to any of the treasure.
	e.g.
	Input
	[
	[‘S’, ‘O’, ‘O’, 'S', ‘S’],
	[‘D’, ‘O’, ‘D’, ‘O’, ‘D’],
	[‘O’, ‘O’, ‘O’, ‘O’, ‘X’],
	[‘X’, ‘D’, ‘D’, ‘O’, ‘O’],
	[‘X', ‘D’, ‘D’, ‘D’, ‘O’],
	]
	
	Output
	5
	Explanation
	You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).
 * 
 * @author freddy
 *
 */
public class TreasureIslandII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char[][] grid = {
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}}; 
        System.out.println(minDist(grid));
        
	}
	
	 private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	    public static int minDist(char[][] grid) {
	        Queue<Point> q = collectSources(grid);
	        for (int dist = 0; !q.isEmpty(); dist++) {
	            for (int sz = q.size(); sz > 0; sz--) {
	                Point p = q.poll();
	                
	                if (grid[p.r][p.c] == 'X') return dist;
	                grid[p.r][p.c] = 'D'; // mark as visited
	                
	                for (int[] dir : DIRS) {
	                    int r = p.r + dir[0];
	                    int c = p.c + dir[1];
	                    if (isSafe(grid, r, c)) {
	                        q.add(new Point(r, c));
	                    }
	                }
	                
	            }
	        }
	        return -1;
	    }
	    
	    private static Queue<Point> collectSources(char[][] grid) {
	        Queue<Point> sources = new ArrayDeque<>();
	        for (int r = 0; r < grid.length; r++) {
	            for (int c = 0; c < grid[0].length; c++) {
	                if (grid[r][c] == 'S') {
	                    sources.add(new Point(r, c));
	                }
	            }
	        }
	        return sources;
	    }
	    
	    private static boolean isSafe(char[][] grid, int r, int c) {
	        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != 'D';
	    }
	    
	    private static class Point {
	        int r, c;
	        Point(int r, int c) {
	            this.r = r;
	            this.c = c;
	        }
	    }


}
