class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        
        int keep = 0;
        int swap = 1;
        
        for (int i = 1; i < n; i++) {
            int newKeep = Integer.MAX_VALUE;
            int newSwap = Integer.MAX_VALUE;
            
            if (nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]) {
                newKeep = keep;
                newSwap = swap + 1;
            }
            
            if (nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]) {
                newKeep = Math.min(newKeep, swap);
                newSwap = Math.min(newSwap, keep + 1);
            }
            
            keep = newKeep;
            swap = newSwap;
        }
        
        return Math.min(keep, swap);
    }
}