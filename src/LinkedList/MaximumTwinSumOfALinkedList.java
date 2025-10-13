class MaximumTwinSumOfALinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);

		System.out.println(twinSum(head));
	}

	static ListNode front;
    static int max;
    public static int twinSum(ListNode head) {
        front = head;
        max = 0;
        helper(head);
        return max;
    }
    
    public static void helper(ListNode curr) {
        if(curr==null) {
            return;
        }
        helper(curr.next); 
        max = Math.max(max, front.val+curr.val);
        front=front.next;
    }
}