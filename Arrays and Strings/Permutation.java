/*
Given two strings, write a method to decide if one is a permutation of the other.
*/

//case sensitive or not?

//sorting the strings will put the characters from two permutations in the same order
public String sort(String s){
	char[] content = s.toCharArray();
	Arrays.sort(content);
	return new String(content);
}

public boolean permutation(String s, String t){
	//if they are different lengths, they cannot be permutations
	if (s.length() != t.length())
		return false;
	return sort(s).equals(sort(t));
}

//check if the two strings have identical characters counts
public boolean permutation(String s, String t){
	if (s.length() != t.length())
		return false;
	int[] letters = new int[256];

	char[] s_array = s.toCharArray();
	for (char c: s_array){
		letters[c]++;
	}

	for (int i = 0; i < t.length(); i++){
		int c = (int)t.charAt(i);
		if (--letters[c] < 0)
			return false;
	}
	return true;
}