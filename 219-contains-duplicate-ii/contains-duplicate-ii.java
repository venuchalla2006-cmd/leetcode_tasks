class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]); // remove element outside window
            }
            if (!set.add(nums[i])) { // add returns false if element already exists
                return true;
            }
        }
        return false;
    }
}
