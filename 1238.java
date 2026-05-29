import java.util.*;

class Solution {
    public List<Integer> circularPermutation(int n, int start) {

        List<Integer> ans = new ArrayList<>();

        int size = 1 << n;

        for (int i = 0; i < size; i++) {
            ans.add((i ^ (i >> 1)) ^ start);
        }

        return ans;
    }
}