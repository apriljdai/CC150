/*
Implement a function to check if a binary tree is balanced.
For the purposes of this question, a balanced tree is defined to be a tree such taht the heights of the two subtrees of any node never differ by no more than one.
*/

public boolean isBalanced(TreeNode root){
	if (root == null)
		return true;
	if (Math.abs(height(root.left) - height(root.right)) > 1)
		return false;
	else
		return isBalanced(root.left) && isBalanced(root.right);
}

public int height(TreeNode node){
	if (node == null)
		return 0;
	return Math.max(height(node.left), height(node.right)) + 1;
}
//runtime: O(NlogN)

//height could check if the tree is balanced or not
public int height(TreeNode node){
	if (node == null)
		return 0;

	int left = height(node.left);
	if (left == -1)
		return -1;

	int right = height(node.right);
	if (right == -1)
		return -1;

	if (Math.abs(height(node.left) - height(node.right)) > 1){
		return -1;
	}
	else{
		return Math.max(height(node.left), height(node.right));
	}
}

public boolean isBalanced(TreeNode root){
	if (height(root) == -1)
		return false;
	return true;
}
//runtime: O(N), space: O(H)