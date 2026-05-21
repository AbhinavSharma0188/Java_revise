class MajorityChecker {

    Map<Integer, List<Integer>> map;
    int[] arr;
    Random rand;

    public MajorityChecker(int[] arr) {

        this.arr = arr;
        this.rand = new Random();

        map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int threshold) {

        for (int i = 0; i < 20; i++) {

            int index = left + rand.nextInt(right - left + 1);

            int candidate = arr[index];

            List<Integer> list = map.get(candidate);

            int count =
                upperBound(list, right) - lowerBound(list, left);

            if (count >= threshold) {
                return candidate;
            }
        }

        return -1;
    }

    private int lowerBound(List<Integer> list, int target) {

        int left = 0;
        int right = list.size();

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int upperBound(List<Integer> list, int target) {

        int left = 0;
        int right = list.size();

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}