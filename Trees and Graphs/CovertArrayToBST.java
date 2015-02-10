/*
Given a sorted array with unique integer elements, write an algorithm to create a binary search tree with minal height
*/

public TreeNode newBST(int[] arr){
	return newBST(arr, 0, arr.length - 1);
}

public TreeNode newBST(int[] arr, int start, int end){
	if (start > end)
		return null;
	int mid = (start + end) / 2;
	TreeNode n = new TreeNode(arr[mid]);
	n.left = newBST(arr, start, mid - 1);
	n.right = newBST(arr, mid + 1, end);
	return n;
}
//runtime: O(NlogN)