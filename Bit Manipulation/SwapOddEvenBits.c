/*
Write a program to swap odd and even bits in an integer with as few instructions as possible (eg. bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
*/

//mask all odd bits with 10101010 in binary, then shift them right by 1 to put them in the even spots.
//same for even bits.
//merge those two values

int swapOddEvenBits(int x){
	//The number 0xAAAAAAAA is a 32 bit number with all even bits set as 1 and all odd bits as 0.
	//The number 0x55555555 is a 32 bit number with all odd bits set as 1 and all even bits as 0.
	return (((x & 0*aaaaaaaa) >> 1) | ((x & 0 *55555555) << 1));
}
