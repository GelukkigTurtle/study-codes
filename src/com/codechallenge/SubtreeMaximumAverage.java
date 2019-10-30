package com.codechallenge;

import java.util.Arrays;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * Given an N-ary tree, find the subtree with maximum average. Return the root of the subtree.
	A subtree of a tree is any node of that tree plus all its descendants. The average value of a subtree is the sum of its values, divided by the number of nodes.
	
	Example 1:
	 * Output: 13
	Explanation: For the node with value = 13 we have an average of (13 + 4 + -2) / 3 = 5 which is the maximum.
	
	Example 2:
	
	Input:
	Output: 21
	Explanation:
	For the node with value = 1 we have an average of (- 5 + 21 + 5 - 1) / 5 = 4.
	For the node with value = -5 we have an average of (-5 / 1) = -5.
	For the node with value = 21 we have an average of (21 / 1) = 21.
	For the node with value = 5 we have an average of (5 / 1) = 5.
	For the node with value = -1 we have an average of (-1 / 1) = -1.
	So the subtree of 21 is the maximum.

 */
public class SubtreeMaximumAverage {

	public static void main(String[] args) {
		TreeNode tree = buildTree();
		TreeNode result = maximumAverageSubtree(tree);
		System.out.println(result);

	}
	
	class TreeNode {
	    public TreeNode(int i) {
	    	val = i;
	    }
		public int val;
	    public List<TreeNode> children;
	}

	
	static double max = Integer.MIN_VALUE;
	static TreeNode maxNode = null;

	public static TreeNode maximumAverageSubtree(TreeNode root) {
	    if (root == null) return null;
	    helper(root);
	    return maxNode;
	}

	private static double[] helper(TreeNode root) {
	    if (root == null) return new double[] {0, 0};

	    double curTotal = root.val;
	    double count = 1;
	    for (TreeNode child : root.children) {
	        double[] cur = helper(child);
	        curTotal += cur[0];
	        count += cur[1];
	    }        
	    double avg = curTotal / count;
	    if (count > 1 && avg > max) { //taking "at least 1 child" into account
	        max = avg;
	        maxNode = root;
	    }
	    return new double[] {curTotal, count};
	}
	
	public static TreeNode buildTree(){
		SubtreeMaximumAverage main = new SubtreeMaximumAverage();
        TreeNode root = main.new TreeNode(20);
        TreeNode sub1 = main.new TreeNode(12);
        for( int i: Arrays.asList( 11, 2, 3 ) ) sub1.children.add( main.new TreeNode( i ) );
        TreeNode sub2 = main.new TreeNode( 18 );
        for( int i: Arrays.asList( 15, 8 ) )    sub2.children.add( main.new TreeNode( i ) );
        root.children.addAll( Arrays.asList( sub1, sub2 ) );

        return root;
    }
	
	/**
	 * 
	 * 
	 * double max = Integer.MIN_VALUE;
		TreeNode maxNode = null;
		
		public TreeNode maximumAverageSubtree(TreeNode root) {
		    if (root == null) return null;
		    helper(root);
		    return maxNode;
		}
		
		private double[] helper(TreeNode root) {
		    if (root == null) return new double[] {0, 0};
		
		    double curTotal = root.val;
		    double count = 1;
		    for (TreeNode child : root.children) {
		        double[] cur = helper(child);
		        curTotal += cur[0];
		        count += cur[1];
		    }        
		    double avg = curTotal / count;
		    if (count > 1 && avg > max) { //taking "at least 1 child" into account
		        max = avg;
		        maxNode = root;
		    }
		    return new double[] {curTotal, count};
}
	 */
}
