/*
Implement a function to check if a binary tree is a binary search tree
*/

public boolean isBST(TreeNode root){
	return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

public boolean isBST(TreeNode node, int min, int max){
	if (node == null)
		return true;
	if (node.val <= min || node.val >= max){
		return false;
	}
	return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
}