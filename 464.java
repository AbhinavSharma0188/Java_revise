class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;

        int s1Count = 0, s2Count = 0, index = 0;
        int[] recall = new int[s2.length() + 1];
        int[] count = new int[s2.length() + 1];

        while (true) {
            s1Count++;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;
                    if (index == s2.length()) {
                        s2Count++;
                        index = 0;
                    }
                }
            }

            if (s1Count == n1) {
                return s2Count / n2;
            }

            if (recall[index] != 0) {
                int prevS1Count = recall[index];
                int prevS2Count = count[index];

                int cycleS1 = s1Count - prevS1Count;
                int cycleS2 = s2Count - prevS2Count;

                int remaining = n1 - s1Count;
                int times = remaining / cycleS1;

                s1Count += times * cycleS1;
                s2Count += times * cycleS2;
            }

            recall[index] = s1Count;
            count[index] = s2Count;
        }
    }
}