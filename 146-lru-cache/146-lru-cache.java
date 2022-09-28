class LRUCache {
    
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    
    Node head;
    Node tail;
    int capacity;
    
    HashMap<Integer, Node> map;
    
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
    
    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        removeNode(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        // existing
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToHead(node);
        } 
        // fresh
        else {
            Node node = new Node(key, value);
            if (capacity == map.size()) {
                // Node tailPrev = tail.prev;
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            addToHead(node);
            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */