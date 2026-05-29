import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int count = 0;
        int odd = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {

            odd += num % 2;

            count += map.getOrDefault(odd - k, 0);

            map.put(odd, map.getOrDefault(odd, 0) + 1);
        }

        return count;
    }
}