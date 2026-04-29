class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        long total = 0;
        char[] arr = s.toCharArray();

        for (int i = n - 1; i >= 0; i--) {
            total = (total + shifts[i]) % 26;
            arr[i] = (char) ((arr[i] - 'a' + total) % 26 + 'a');
        }

        return new String(arr);
    }
}