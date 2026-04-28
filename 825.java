class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int left = 0, right = 0, res = 0;

        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 15) continue;

            while (ages[left] <= 0.5 * ages[i] + 7) left++;
            while (right < ages.length && ages[right] <= ages[i]) right++;

            res += right - left - 1;
        }

        return res;
    }
}