/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode node : lists) {
            if(node != null) 
                pq.add(node);
        }
        
        ListNode first = new ListNode(-1);
        ListNode curr = first;
        while(!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if(temp.next != null)
                pq.add(temp.next);
            curr.next = temp;
            curr = curr.next;
        }
        
        return first.next;
    }
}