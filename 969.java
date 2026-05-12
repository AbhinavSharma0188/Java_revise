class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();

        for (int size = arr.length; size > 1; size--) {
            int maxIndex = 0;

            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }

            if (maxIndex == size - 1) {
                continue;
            }

            reverse(arr, maxIndex);
            result.add(maxIndex + 1);

            reverse(arr, size - 1);
            result.add(size);
        }

        return result;
    }

    private void reverse(int[] arr, int end) {
        int start = 0;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}