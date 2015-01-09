/*
Implement an algorithm to find the kth to last element of a singly linked list
*/

//recursive method
public class IntWrapper {
	public int value = 0;
}
LinkedListNode nthToLast(LinkedListNode head, int k, IntWrapper i){
	if (head == null)
		return null;
	LinkedListNode node = nthToLast(head.next, k, i);
	i.value += 1;
	if (i.value == k)
		return head;
	return node;
}

//iterative way
LinkedListNode nthToLast(LinkedListNode head, int k){
	if (k <= 0)
		return null;
	//use two pointer p1 and p2, keep them in k space
	LinkedListNode p1 = head;
	LinkedListNode p2 = head;
	for (int i = 0; i < k - 1; i++){
		if (p1 != null)
			p1 = p1.next;
		else 
			return null;
	}
	//check if the current p1 is empty or not
	if (p1 == null)
		return null;
	while (p1.next != null){
		p1 = p1.next;
		p2 = p2.next;
	}
	return p1;
}
//runtime: O(N), space: O(1)