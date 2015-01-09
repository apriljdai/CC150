/*
Write a method to replace all spaces in a string with '%20', you may assume that the string has sufficient space at the end of the string to hold the additional characters, and that you are given the "true" length of the string.
(Note: if implementing in Java, please use a character array so that you can perform this operation in place)
*/

//edit the string starting from the end and work backwards(have extra buffer at the end)
//two scan approach
//first:count how many spaces there are in the string
//second:editing the string

public void replacesSpaces(char[] str, int length){
	int space_count = 0; 
	int i;
	//first:count how many spaces there are in the string
	for (i = 0; i < length; i++){
		if (str[i] == ' ')
			space_count++;
	}
	int newLength = length + 2 * spaceCount; //cause '%20' needs 3 spaces
	str[newLength] = '\0';
	//second:editing the string
	for (i = length - 1; i >= 0; i--){
		if (str[i] == ' '){
			str[newLength - 1] = '0';
			str[newLength - 2] = '2';
			str[newLength - 3] = '%';
			newLength -= 3;
		}
		else{
			str[newLength -1] = str[i];
			newLength -= 1;
		}
	}
}