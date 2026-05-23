class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] freq = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            freq[i] = smallestCharFrequency(words[i]);
        }

        Arrays.sort(freq);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int qFreq = smallestCharFrequency(queries[i]);
            int idx = upperBound(freq, qFreq);
            result[i] = freq.length - idx;
        }

        return result;
    }

    private int smallestCharFrequency(String s) {
        char minChar = 'z';
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c < minChar) {
                minChar = c;
                count = 1;
            } else if (c == minChar) {
                count++;
            }
        }

        return count;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}