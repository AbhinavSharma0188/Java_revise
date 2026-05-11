class Solution {
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);

        for (int rod : rods) {
            Map<Integer, Integer> current = new HashMap<>(dp);

            for (int diff : current.keySet()) {
                int height = current.get(diff);

                dp.put(diff + rod,
                        Math.max(dp.getOrDefault(diff + rod, 0), height));

                int newDiff = Math.abs(diff - rod);
                int newHeight = height + Math.min(diff, rod);

                dp.put(newDiff,
                        Math.max(dp.getOrDefault(newDiff, 0), newHeight));
            }
        }

        return dp.get(0);
    }
}