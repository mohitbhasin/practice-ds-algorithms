class LRUCache {
    Map<Integer, ListNode> cache;
    int size;
    int capacity;
    LinkedList linkedList;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        this.linkedList = new LinkedList();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            ListNode curr = cache.get(key);
            linkedList.remove(curr);
            linkedList.addHead(curr);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            ListNode curr = cache.get(key);
            curr.key = key;
            curr.val = value;
            linkedList.remove(curr);
            linkedList.addHead(curr);
        } else {
            ListNode curr = new ListNode(key, value);
            cache.put(key, curr);
            linkedList.addHead(curr);
            size++;
            if(size>capacity) {
                ListNode tailNode = linkedList.removeTail();
                if(tailNode!=null) {
                    cache.remove(tailNode.key);
                }
            }
        }
    }
    
    class LinkedList {
        ListNode head;
        ListNode tail;
        
        public LinkedList() {
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.prev = head;
        }
        
        public void addHead(ListNode curr) {
            curr.prev = head;
            curr.next = head.next;
            head.next.prev = curr;
            head.next = curr;
        }
        
        public ListNode removeTail() {
            if(tail.prev!=head) {
                ListNode tailNode = tail.prev;
                remove(tailNode);
                return tailNode;
            }
            return null;
        }
        
        public void remove(ListNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        
    }
    
    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        ListNode() {

        }
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
}