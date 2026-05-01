import java.util.*;

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        
        int[][] b = new int[n][2];
        for (int i = 0; i < n; i++) {
            b[i][0] = nums2[i];
            b[i][1] = i;
        }
        Arrays.sort(b, (x, y) -> x[0] - y[0]);
        
        int left = 0, right = n - 1;
        int[] res = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            if (nums1[right] > b[i][0]) {
                res[b[i][1]] = nums1[right];
                right--;
            } else {
                res[b[i][1]] = nums1[left];
                left++;
            }
        }
        
        return res;
    }
}