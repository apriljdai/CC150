/*
Imagine you are reading in a stream of integers. Periodically, you wish to be able to look up the rank of a number x (the number of values less than or equal to x). 
Implement the data structures and algorithms to support these operations. 
That is, implement the method track(int x), which is called when each number is generated, 
and the method getRankOfNumber(int x), which returns the number of values less than or equal to x (not including x itself)
*/

//use binary search tree to solve the problem

public class Operation {
	private static RankNode root = null;

	public void track(int x){
		if (root == null)
			root = new RankNode(x);
		else
			root.insert(x);
	}

	public int getRankOfNumber(int x){
		return root.getRank(x);
	}
}
public class RankNode {
	public int left_size = 0;
	public RankNode left;
	public RankNode right;
	public int data = 0;
	public RankNode(int d){
		data = d;
	}

	public void insert(int d){
		if (d <= data){
			if (left != null)
				left.insert(d);
			else
				left = new RankNode(d);
			left_size++;
		}
		else{
			if (right != null)
				right.insert(d);
			else
				right = new RankNode(d);
		}
	}

	public int getRank(int d){
		if (d == data){
			return left_size;
		}
		else if(d < data){
			if (left == null)
				return -1;
			else
				return left.getRank(d);
		}
		else{
			int right_size = right == null ? -1 : right.getRank(d);
			if (right_size == -1)
				return -1;
			else
				return left_size + 1 + right_size;
		}
	}
}