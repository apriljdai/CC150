/*
Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures
*/

//create an array of boolean values
public boolean isUniqueChars(String str){
	//automatically return false if the length of the string is greater than the number of unique characters in hte alphabet
	if (str.length() > 256)
		return false;
	boolean[] char_set = new boolean[256];
	for (int i = 0; i < str.length(); i++){
		int val = str.charAt(i);
		if (char_set[val])
			return false;
		char_set[val] = true;
	}
	return true;
}
//time complexity: O(N), space complexity: O(1)

//reduce the space usage by a factor of eight by using a bit vector (later)