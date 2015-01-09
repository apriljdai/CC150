/*
Write code to remove duplicates from an usorted linked list
How would you solve this problem if a temporary buffer is not allowed?
*/

public void deleteDups(LinkedListNode n){
	Hashtable table = new Hashtable();
	LinkedListNode current = null;
	while (n != null){
		if (table.containsKey(n.data))
			current.next = n.next;
		else{
			table.put(n.data, true);
			curent = n;
		}
		n = n.next;
	}
}
//runtime: O(N)

//No buffer allowed
//iterate with two pointers: 
//current which iterates through the linked list
//runner which checks all subsequent nodes for duplicates
public void deleteDups(LinkedListNode head){
	if (head == null) 
		return;
	LinkedListNode current = head;
	while (current != null){
		LinkedListNode runner = current;
		while (runner.next != null){
			if (current.data == runner.next.data)
				runner.next = runner.next.next;
			else
				runner = runner.next;
		}
		current = current.next;
	}
}
//runtime: O(N^2), space: O(1)