/*
Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
*/

int bitSwapRequired(int a, int b){
	int count = 0;
	for (int c = a ^ b; c != 0; c = c >> 1){
		count += c & 1;
	}
	return count;
}

int bitSwapRequired(int a, int b){
	int count = 0;
	for (int c = a ^ b; c != 0; c = c & (c - 1))
		count++;
	return count;
}