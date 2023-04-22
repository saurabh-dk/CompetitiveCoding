class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int comp;
        for(int i = 0; i < nums.length; i++) {
            comp = target - nums[i];
            if(map.containsKey(comp)) return new int[] {i, map.get(comp)};
            
            map.put(nums[i], i);
        }
        
        return null;
    }
}