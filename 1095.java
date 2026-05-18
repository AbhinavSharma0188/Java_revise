class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int peak = findPeak(mountainArr, n);

        int left = binarySearch(mountainArr, target, 0, peak, true);

        if (left != -1) {
            return left;
        }

        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    private int findPeak(MountainArray mountainArr, int n) {
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int binarySearch(MountainArray mountainArr, int target, int low, int high, boolean ascending) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            }

            if (ascending) {
                if (value < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (value > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}