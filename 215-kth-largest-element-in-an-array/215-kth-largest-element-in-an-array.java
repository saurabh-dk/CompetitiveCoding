class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        
        for(int num : nums) {
            q.add(num);
        }
        
        int count = 0;
        
        while(count != k-1) {
            q.poll();
            count++;
        }
        
        return q.peek();
    }
}