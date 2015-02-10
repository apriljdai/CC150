/*
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list.
Write a function that adds the two numbers and returns the sum as a linked list
Follow up: Suppose the digits are stored in forward order.
*/

public LinkedListNode addList(LinkedListNode n1, LinkedListNode n2 int carry){
	if (n1 == null && n2 == null && carry == 0)
		return null;
	LinkedListNode res = new LinkedListNode();

	while (n1 != null || n2 != null || carry != 0){
		int value = carry;
		if (n1 != null){
			value += n1.data;
			n1 = n1.next;
		}
		if (n2 != null){
			value += n2.data;
			n2 = n2.next;
		}
		res.data = value % 10;
		carry = value / 10;
		res = res.next;
	}
	return res;
}

//follow up
//take care if two list are not the same length
