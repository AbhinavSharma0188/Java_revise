class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();

        while (label >= 1) {
            result.add(label);

            int level = (int)(Math.log(label) / Math.log(2));
            int start = (int)Math.pow(2, level);
            int end = (int)Math.pow(2, level + 1) - 1;

            label = (start + end - label) / 2;
        }

        Collections.reverse(result);
        return result;
    }
}