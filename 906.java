class Solution {
    public int superpalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        int count = 0;

        for (int k = 1; k < 100000; k++) {
            String s = Integer.toString(k);
            String rs = new StringBuilder(s).reverse().toString();

            long pal = Long.parseLong(s + rs.substring(1));
            long sq = pal * pal;
            if (sq > r) break;
            if (sq >= l && isPal(sq)) count++;
        }

        for (int k = 1; k < 100000; k++) {
            String s = Integer.toString(k);
            String rs = new StringBuilder(s).reverse().toString();

            long pal = Long.parseLong(s + rs);
            long sq = pal * pal;
            if (sq > r) break;
            if (sq >= l && isPal(sq)) count++;
        }

        return count;
    }

    private boolean isPal(long x) {
        String s = Long.toString(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}