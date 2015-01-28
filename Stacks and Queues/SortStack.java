/*
Write a program to sort a stack in ascending order(with biggest item on top).
You may use at most one additional stack to hold items, but you may not copy the elements into any other data structure(such as an array).
The stack supports the following operations: push, pop, peek, and isEmpty.
*/

//put the element in the temp, find the right position then insert
public Stack<Integer> sort(Stack<Integer> s){
	Stack<Integer> res = new Stack<Integer>();
	while (!s.isEmpty()){
		int temp = s.pop();
		while(!res.isEmpty() && res.peek() > temp){
			s.push(res.pop());
		}
		res.push(temp);
	}
	return res;
}
//runtime: O(N^2), space: O(N)