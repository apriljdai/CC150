/*
Explain what the following code does: ((n & (n - 1)) == 0).
*/

// A & B == 0 -> A and B never have a 1 bit in the same place.
n and (n - 1) never share a 1.

// (n - 1) look like as compared with n
n - 1 will look like n, except that n's initial 0s will be 1s in n - 1, and n's least significant 1 will be 0 in n - 1.
eg. n 	  = abcde1000
	n - 1 = abcde0111

// n & (n - 1) == 0
abcde must be all 0s.-> checks if n is a power of 2. 