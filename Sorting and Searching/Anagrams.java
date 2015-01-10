/*
Write a method to sort an array of strings so that all the anagrams are next to each other
*/

public void sort(String[] arr){
	ArrayList<String> result = new ArrayList<String>();
	HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

	for (String s: arr){
		char[] temp = s.toCharArray(s);
		Arrays.sort(temp);
		String key = new String(temp);
		if (map.containsKey(key)){
			map.get(key).add(s);
		}
		else{
			ArrayList<String> list = new ArrayList<String>();
			list.add(s);
			map.put(key, list);
		}
	}

	Set<String> set = map.keySet();
	for (String s: set){
		ArrayList<String> value = map.get(s);
		if (value.size() > 1)
			result.addAll(value);
	}
}