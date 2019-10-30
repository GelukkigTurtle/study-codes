package com.codebasics.trees;

public class PathsWithSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		root.right.right.right.right = new TreeNode(1);

		int sum = 23;

		System.out.println(new Solution().hasPathSum(root, sum));
		System.out.println("size: " + root.size(root));
		System.out.println("depth: " + root.maxDepth(root));
		System.out.println("width: " + root.getMaxWidth(root));

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	int size(TreeNode node) {
		if (node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}

	int maxDepth(TreeNode node) {
		if (node == null)
			return 0; //this should be -1 in case the root not count.
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	int getMaxWidth(TreeNode node) {
		int maxWidth = 0;
		int width;
		int h = maxDepth(node);
		int i;

		/*
		 * Get width of each level and compare the width with maximum width so far
		 */
		for (i = 1; i <= h; i++) {
			width = getWidth(node, i);
			if (width > maxWidth)
				maxWidth = width;
		}

		return maxWidth;
	}

	/* Get width of a given level */
	int getWidth(TreeNode node, int level) {
		if (node == null)
			return 0;

		if (level == 1)
			return 1;
		else if (level > 1)
			return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
		return 0;
	}
}

class Solution {
	boolean dfs(TreeNode node, int count, int sum) {
		if (node.right == null && node.left == null) {
			return count == sum;
		}
		boolean resLeft = false, resRight = false;
		if (node.left != null)
			resLeft = dfs(node.left, count + node.left.val, sum);
		if (node.right != null)
			resRight = dfs(node.right, count + node.right.val, sum);
		return resLeft || resRight;
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		return dfs(root, root.val, sum);
	}

}
