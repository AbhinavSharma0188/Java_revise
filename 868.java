class Solution {
    public int binaryGap(int n) {
        int last = -1, res = 0, index = 0;
        
        while (n > 0) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    res = Math.max(res, index - last);
                }
                last = index;
            }
            n >>= 1;
            index++;
        }
        
        return res;
    }
}