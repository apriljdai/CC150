/*
Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
*/

//Linkedlist shift is much easier than array shifting

//create two different linked lists: one less than x, one greater or equal to x
public LinkedlistNode partition(LinkedlistNode node, int x){
	LinkedlistNode beforestart = null;
	LinkedlistNode beforeend = null;
	LinkedlistNode afterstart = null;
	LinkedlistNode afterend = null;

	while (node != null){
		LinkedlistNode next = node.next;
		node.next = null;
		if (node.data < x){
			if (beforestart == null){
				beforestart = node;
				beforeend = beforestart;
			}
			else{
				beforestart.next = node;
				beforeend = node;
			}
		}
		else{
			if (afterstart = null){
				afterstart = node;
				afterend = afterstart;
			}
			else{
				afterstart.next = node;
				afterend = node;
			}
		}
		node = next;
	}
	if (beforestart == null)
		return afterstart;
	beforeend.next = afterstart;
	return beforestart;
}

//insert nodes into the front of them
public LinkedlistNode partition(LinkedlistNode node, int x){
	LinkedlistNode beforestart = null;
	LinkedlistNode afterstart = null;

	while (node != null){
		LinkedlistNode next = node.next;
		if (node.data < x){
			node.next = beforestart;
			beforestart = node;
		}
		else{
			node.next = afterstart;
			afterstart = node;
		}
		node = next;
	}

	if (beforestart == null)
		return afterstart;
	LinkedlistNode head = beforestart;
	while(beforestart.next != null)
		beforestart = beforestart.next;
	beforestart.next = afterstart;
	return head;
}