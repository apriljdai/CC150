/*
How would you design a stack which, in addition to push and pop, also has a function min which returns the minnimum element? 
Push, pop and min should all operate in O(1) time
*/

//using an additional stack which keeps track of the mins
public class StackWithMin {
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();

	public void push(int value){
		if (value <= min.peek()){
			min.push(value);
		}
		s.push(value);
	}

	public int pop(){
		int res = s.pop();
		if (res == min.peek()){
			min.pop();
		}
	}

	public int minimum(){
		if (min.isEmpty()){
			return Integer. MAX_VALUE;
		return min.peek();
	}
}