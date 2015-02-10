/*
Imagine a stack of plates. If the stack gets too high, it might topple. 
Therefore, in real lift, we would likely start a new stack when the previous stack exceeds some threshold.
Implement a data structure SetOfStacks that mimics this.
SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack.
*/

public class SetOfStacks {
	ArrayList<Stack> stacks = ArrayList<Stack>();
	public int capacity;

	public Stack getLastStack(){
		if (stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}

	public void push(int v){
		Stack last = getLastStack();
		if (last != null && !last.isFull()){
			last.push(v);
		}
		else{
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	public void pop(){
		Stack last = getLastStack();
		int v = last.pop();
		if (last.size == 0){
			stacks.remove(stacks.size() - 1);
		}
	}
	/*
	follow up: implement a function popAt(int index) which performs a pop operation on a specific sub-stack
	*/
	//rollover system: if pop an element from stack 1, we need to remove the bottom of stack 2 and pucsh it onto stack 1.

}