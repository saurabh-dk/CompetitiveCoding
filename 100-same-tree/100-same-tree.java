/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(p);
        que.add(q);
        
        while(!que.isEmpty()) {
            TreeNode currp = que.poll();
            TreeNode currq = que.poll();
            
            if(currp == null && currq == null) continue;
            else if(currp == null || currq == null || currp.val != currq.val)
                return false;
        
            que.add(currp.left);
            que.add(currq.left);
            que.add(currp.right);
            que.add(currq.right);
        }
        return true;
    }
}