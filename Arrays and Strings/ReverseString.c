/*
Implement a function void reverse(char *str) in C or C++ which reverses a null-terminated string
*/

//do it in place

void reverse(char * str){
	int len = strlen(str);
	for (int i = 0; i < len / 2; i++){
		char temp = str[i];
		str[i] = str[len - i - 1];
		str[len - i - 1] = temp;
	}
}

