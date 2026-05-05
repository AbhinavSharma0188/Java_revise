class Solution {
    public int[] threeEqualParts(int[] arr) {
        int ones = 0;
        for (int x : arr) if (x == 1) ones++;
        if (ones % 3 != 0) return new int[]{-1, -1};
        if (ones == 0) return new int[]{0, arr.length - 1};

        int k = ones / 3;
        int i1 = -1, i2 = -1, i3 = -1;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                if (count == 1) i1 = i;
                else if (count == k + 1) i2 = i;
                else if (count == 2 * k + 1) i3 = i;
            }
        }

        int len = arr.length - i3;

        if (i1 + len <= i2 && i2 + len <= i3) {
            for (int i = 0; i < len; i++) {
                if (arr[i1 + i] != arr[i2 + i] || arr[i1 + i] != arr[i3 + i])
                    return new int[]{-1, -1};
            }
            return new int[]{i1 + len - 1, i2 + len};
        }

        return new int[]{-1, -1};
    }
}