/*
Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the compressed string would not become smaller than the original string, your method should return the original string.
*/

String compressBetter(String str){
	//return the original string if the compressed string would not become smaller than the original one
	int size = countCompression(str);
	if (size >= str.length())
		return str;

	char[] array = new char[size];
	int index = 0;
	char last = str.charAt(0);
	int count = 1;
	for (int i = 1; i < str.length(); i++){
		if (str.charAt(i) == last)
			count++;
		else{
			index = setChar(array, last, index, count);
			count = 1;
			last = str.charAt(i);
		}
	}
	index = setChar(array, last, index, count);
	return String.valueOf(array);
}

//in order to reduce the repeatation of the code
int setChar(char[] array, char last, int index, int count){
	array[index] = last;
	index ++;
}

int countCompression(String str){
	if (str == null || str.length() == 0)
		return 0;
	char last = str.charAt(0);
	int size = 0; 
	int count = 1;
	for (int i = 1; i < str.length(); i++){
		if (str.charAt(i) == last)
			count++;
		else{
			last = str.charAt(i);
			count = 1;
			size += 1 + String.valueOf(count).length();
		}
	}
	size += 1 + String.valueOf(count).length();
	return size;
}
//runtime: O(N), space: O(N)