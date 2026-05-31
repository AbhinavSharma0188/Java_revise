class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result = new ArrayList<>();

        int jumbo = tomatoSlices - 2 * cheeseSlices;

        if (jumbo < 0 || jumbo % 2 != 0) {
            return result;
        }

        jumbo /= 2;
        int small = cheeseSlices - jumbo;

        if (small < 0) {
            return result;
        }

        result.add(jumbo);
        result.add(small);

        return result;
    }
}