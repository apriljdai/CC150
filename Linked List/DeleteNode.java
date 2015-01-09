/*
Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
*/

public void deleteNode(LinkedListNode n){
	if (n == null || n.next == null)
		return;
	LinkedListNode node = n.next;
	n.data = node.data;
	n.next = node.next;
	return;
}