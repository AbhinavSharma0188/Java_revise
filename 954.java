class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(nums, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        for (int num : nums) {
            if (map.get(num) == 0) {
                continue;
            }

            if (map.getOrDefault(num * 2, 0) == 0) {
                return false;
            }

            map.put(num, map.get(num) - 1);
            map.put(num * 2, map.get(num * 2) - 1);
        }

        return true;
    }
}