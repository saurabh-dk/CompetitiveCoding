class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> vals = new HashSet<>();
        for(int num : nums) {
            if(vals.contains(num)) return true;
            else vals.add(num);
        }
        return false;
    }
}