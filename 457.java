class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int slow = i, fast = i;
            boolean forward = nums[i] > 0;
            
            while (true) {
                slow = next(nums, forward, slow);
                if (slow == -1) break;
                
                fast = next(nums, forward, fast);
                if (fast == -1) break;
                
                fast = next(nums, forward, fast);
                if (fast == -1) break;
                
                if (slow == fast) return true;
            }
        }
        
        return false;
    }
    
    private int next(int[] nums, boolean forward, int i) {
        boolean dir = nums[i] > 0;
        if (dir != forward) return -1;
        
        int n = nums.length;
        int next = ((i + nums[i]) % n + n) % n;
        
        if (next == i) return -1;
        
        return next;
    }
}