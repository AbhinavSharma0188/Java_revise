class Solution {
    public boolean queryString(String s, int n) {
        for (int i = n; i > n / 2; i--) {
            String binary = Integer.toBinaryString(i);

            if (!s.contains(binary)) {
                return false;
            }
        }

        return true;
    }
}