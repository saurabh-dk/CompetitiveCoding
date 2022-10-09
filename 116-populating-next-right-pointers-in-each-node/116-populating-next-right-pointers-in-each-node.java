/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            for(int i = 0; i < size; i++) {
                Node curr = q.poll();
                if(i != 0) {
                    prev.next = curr;
                }
                if(curr.left != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
                prev = curr;
            }
        }
        return root;
    }
}