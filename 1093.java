class Solution {
    public double[] sampleStats(int[] count) {
        double min = -1;
        double max = 0;
        double mean = 0;
        double median = 0;
        double mode = 0;

        int totalCount = 0;
        long totalSum = 0;

        int maxFreq = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (min == -1) {
                    min = i;
                }

                max = i;

                totalCount += count[i];
                totalSum += (long) i * count[i];

                if (count[i] > maxFreq) {
                    maxFreq = count[i];
                    mode = i;
                }
            }
        }

        mean = (double) totalSum / totalCount;

        int mid1 = (totalCount + 1) / 2;
        int mid2 = (totalCount + 2) / 2;

        int curr = 0;
        int m1 = 0;
        int m2 = 0;

        for (int i = 0; i < count.length; i++) {
            curr += count[i];

            if (curr >= mid1 && m1 == 0) {
                m1 = i;
            }

            if (curr >= mid2) {
                m2 = i;
                break;
            }
        }

        median = (m1 + m2) / 2.0;

        return new double[]{min, max, mean, median, mode};
    }
}