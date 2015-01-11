/*
Write a function to swap a number in place(without temporary variables)
*/

//set the original a = A, and original b = B. The difference between A and B = A - B.
//let a = A - B, then b = B + a = A, and a = b - a = A - (A - B) = B.

public void swap(int a, int b){
	a = a - b;
	b = a + b;
	a = b - a;
}

//use bit manipulation
public void swap(int a, int b){
	a = a ^ b;
	b = a ^ b;
	a = a ^ b;
}