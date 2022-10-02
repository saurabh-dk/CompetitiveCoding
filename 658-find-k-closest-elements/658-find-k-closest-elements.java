class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            
            int s = x - arr[mid];
            int e = arr[mid+k] - x;
            
            if(s > e) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = low; i < low+k; i++) {
            res.add(arr[i]);
        }
        
        return res;
    }
}