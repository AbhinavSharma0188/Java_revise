import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if(valueDiff < 0) return false;

        Map<Long, Long> map = new HashMap<>();
        long size = (long) valueDiff + 1;

        for(int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long bucket = getBucket(num, size);

            if(map.containsKey(bucket)) return true;

            if(map.containsKey(bucket - 1) && Math.abs(num - map.get(bucket - 1)) <= valueDiff) return true;
            if(map.containsKey(bucket + 1) && Math.abs(num - map.get(bucket + 1)) <= valueDiff) return true;

            map.put(bucket, num);

            if(i >= indexDiff) {
                long oldBucket = getBucket(nums[i - indexDiff], size);
                map.remove(oldBucket);
            }
        }

        return false;
    }

    private long getBucket(long num, long size) {
        if(num >= 0) return num / size;
        else return ((num + 1) / size) - 1;
    }
}