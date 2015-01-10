/*
Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
*/

//modification of binary search, fix the comparision against mid, incase mid is an empty string

public int searchString(String[] strings, String str){
	if (strings == null || strings.length == 0 || str == null)
		return -1;
	int left = 0, right = strings.length() - 1;
	while (left <= right){
		int mid = (left + right) / 2;

		//mid is an empty string
		if (strings[mid].isEmpty()){
			int templeft = mid - 1;
			int tempright = mid + 1;
			while(true){
				if (templeft < left && tempright > right)
					return -1;
				else if (tempright <= right && !strings[tempright].isEmpty()){
					mid = tempright;
					break;
				}
				else if (templeft >= left && !strings[templeft].isEmpty()){
					mid = templeft;
					break;
				}
				tempright++;
				templeft--;
			}
		}
		if (strings[mid].equals(str))
			return mid;
		else if (strings[mid].compareTo(str) < 0)
			left = mid + 1;
		else 
			right = mid - 1;
	}
	return -1;
}