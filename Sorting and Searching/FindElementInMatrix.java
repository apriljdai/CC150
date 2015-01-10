/*
Given an M*N matrix in which each row and each column is sorted in ascending order, write a method to find an element.
*/

//one good approach: do binary search on every row to find the element. This algorighm will be O(Mlog(N))

public boolean findElement(int[][] matrix, int e){
	int row = 0;
	int col = matrix[0].length - 1;
	while (row < matrix.length && col >= 0){
		if (matrix[row][col] == e)
			return true;
		if (matrix[row][col] < e)
			row++;
		else
			col--;
	}
	return false;
}