class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    HashMap<Integer, ListNode> map;
    int capacity;
    ListNode head,tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
            addNode(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;

            removeNode(node);
            addNode(node);

        } else {
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            addNode(node);
        }
        if (map.size() > capacity) {
            removeTail();
        }
    }
    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addNode(ListNode node) {
        head.next.prev = node;
        node.prev = head;
        node.next = head.next;
        head.next = node;
    }
    private void removeTail(){
        ListNode temp = tail.prev;
        removeNode(temp);
        map.remove(temp.key);
    }
}
