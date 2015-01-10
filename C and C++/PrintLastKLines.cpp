/*
Write a method to print the las K lines of an input file.
*/

//allocate an array for all K lines and the last K lines we've read in the array

void printLastKLines(char * fileName, int k){
	ifstream file(fileName);
	string[] lines = new string[k];
	int size = 0;

	while(file.good()){
		getline(file, lines[size % k]);
		size++;
	}

	int start = size > k ? (size % k) : 0;
	int count = math.min(k, size);

	for (int i = 0; i < count; i++){
		std::cout << lines[(start + i) % k] << std::endl;
	}
}