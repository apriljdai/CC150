/*
Implement a MyQueue class which implements a queue using two stacks.
*/

//need to modify peek() and pop() to go in reverse order
public class MyQueue<T>{
	Stack<T> newStack, oldStack;

	public MYQueue(){
		newStack = new Stack<T>();
		oldStack = new Stack<T>();
	}

	public int size(){
		return newStack.size() + oldStack.size();
	}

	public void add(T val){
		newStack.push(val);
	}

	public void shiftStacks(){
		if (oldStack.isEmpty()){
			while(!newStack.isEmpty()){
				oldStack.push(newStack.pop());
			}
		}
	}
	
	public void peek(){
		shiftStacks();
		return oldStack.peek();
	}

	public void remove(){
		shiftStacks();
		return oldStack.pop();
	}
} 