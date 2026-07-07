class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int[5]; // c, r, o, a, k
        int activeFrogs = 0;
        int maxFrogs = 0;

        for (char ch : croakOfFrogs.toCharArray()) {
            switch (ch) {
                case 'c':
                    count[0]++;
                    activeFrogs++;
                    maxFrogs = Math.max(maxFrogs, activeFrogs);
                    break;

                case 'r':
                    if (count[0] == 0) return -1;
                    count[0]--;
                    count[1]++;
                    break;

                case 'o':
                    if (count[1] == 0) return -1;
                    count[1]--;
                    count[2]++;
                    break;

                case 'a':
                    if (count[2] == 0) return -1;
                    count[2]--;
                    count[3]++;
                    break;

                case 'k':
                    if (count[3] == 0) return -1;
                    count[3]--;
                    activeFrogs--;
                    break;
            }
        }

        if (activeFrogs != 0) return -1;

        return maxFrogs;
    }
}