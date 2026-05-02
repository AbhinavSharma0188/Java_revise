class RLEIterator {
    int[] arr;
    int index;

    public RLEIterator(int[] encoding) {
        arr = encoding;
        index = 0;
    }
    
    public int next(int n) {
        while (index < arr.length && n > arr[index]) {
            n -= arr[index];
            index += 2;
        }
        if (index >= arr.length) return -1;
        arr[index] -= n;
        return arr[index + 1];
    }
}