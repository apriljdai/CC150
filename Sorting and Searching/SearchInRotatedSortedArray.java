/*
Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array. You may assume that the array was originally sorted in increasing order
*/

//no matter rotated how many times, just like rotate once

public int search(int a[], int x){
	int len = a.length;
	int left = 0, right = len - 1;
	while (left <= right){
		if (left == right && a[left] != x)
			return -1;
		int mid = (left + right) / 2;
		if (x = a[mid])
			return mid;
		//a[mid] > a[left] && a[mid] > a[right] => left = mid + 1
		//a[mid] < a[left] && a[mid] < a[right] => right = mid - 1
		//a[mid] > a[left] && a[mid] < a[right] => right = mid - 1
		if (a[mid] > a[left]){
			if (a[mid] > a[right])
				left = mid + 1;
			else
				right = mid - 1;
		}
		else
			right = mid - 1;
	}
	return -1;
}
//runtime: O(logN), if many duplicates, the algorithm is O(N)