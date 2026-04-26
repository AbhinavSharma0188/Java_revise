class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            int low = (i + 1) % n;
            int high = (i - nums[i] + n + 1) % n;
            
            diff[low]++;
            diff[high]--;
            
            if (low >= high) {
                diff[0]++;
            }
        }
        
        int max = 0, score = 0, res = 0;
        
        for (int i = 0; i < n; i++) {
            score += diff[i];
            if (score > max) {
                max = score;
                res = i;
            }
        }
        
        return res;
    }
}