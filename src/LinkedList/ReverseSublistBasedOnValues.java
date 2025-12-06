// Not a official problem. Some cases dont work.
class ReverseSublistBasedOnValues {
	public static void main(String[] args) {
		// ListNode head = new ListNode(1);
		// head.add(3);
		// head.add(5);
		// head.add(7);
		// head.add(9);
		// head.add(6);
		// head.add(8);
		// head.add(2);
		// head.add(4);
		ListNode head = new ListNode(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(5);
		head.add(6);
		head.add(7);
		head.add(8);
		head.add(9);

		reverseBetween(head, 2,8);
		head.printList();
		reverseBetween(head, 2,9);
		head.printList();
		
		// cases not working
		
		// reverseBetween(head, 1,9);
		// head.printList();
		// reverseBetween(head, 5,7);
		// head.printList();
		// reverseBetween(head, 5,9);
		// head.printList();
    }

    // Can have better variable names.
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		// find left node
		ListNode leftPrev = head;
		while(leftPrev.next!=null && leftPrev.next.val!=left) {
		    leftPrev=leftPrev.next;
		}
		ListNode newHead = leftPrev.next;
		ListNode tail = newHead;
		ListNode prev = null;

		while(newHead.val!=right) {
		    ListNode temp = newHead.next;
		    newHead.next = prev;
		    prev=newHead;
		    newHead=temp;
		}
		ListNode newTail = newHead.next;
		newHead.next = prev;

		leftPrev.next = newHead;
		tail.next = newTail;

		return head;
	}
}