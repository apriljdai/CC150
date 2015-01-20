/*
You are given two 32-bit numbres, N and M, and two bit positions, i and j. 
Write a method to insert M into N such that M starts at bit j and ens at bit i. 
Yuu can assume that the bits j through i have enough space to fit all of M. 
That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
You would not, for example, have j = 3 and i = 2, because could not fully fit between bit 3 and bit 2.
*/

//clear the bits j through i in N
//shift M so that it lines up with bits j through i
//merge M and N

int updateBits(int n, int m, int i, int j){
	//create a mask
	int allOne = ~0;
	int left = allOne << (j + 1);
	int right = (1 << i) - 1;
	int mask = left | right;

	int clearN = mask & n;
	int shiftM = m << i;

	return clearN | shfitM;
}