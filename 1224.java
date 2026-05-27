class Solution {
    public int maxEqualFreq(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        int ans = 0;
        int maxFreq = 0;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (count.containsKey(num)) {
                int oldFreq = count.get(num);
                freq.put(oldFreq, freq.get(oldFreq) - 1);

                if (freq.get(oldFreq) == 0) {
                    freq.remove(oldFreq);
                }
            }

            count.put(num, count.getOrDefault(num, 0) + 1);

            int newFreq = count.get(num);

            freq.put(newFreq, freq.getOrDefault(newFreq, 0) + 1);

            maxFreq = Math.max(maxFreq, newFreq);

            int len = i + 1;

            if (maxFreq == 1 ||
                maxFreq * freq.get(maxFreq) + 1 == len ||
                (maxFreq - 1) * (freq.getOrDefault(maxFreq - 1, 0) + 1) == len) {

                ans = len;
            }
        }

        return ans;
    }
}