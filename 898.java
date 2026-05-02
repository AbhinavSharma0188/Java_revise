class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        java.util.Set<Integer> res = new java.util.HashSet<>();
        java.util.Set<Integer> prev = new java.util.HashSet<>();

        for (int num : arr) {
            java.util.Set<Integer> curr = new java.util.HashSet<>();
            curr.add(num);

            for (int p : prev) {
                curr.add(p | num);
            }

            res.addAll(curr);
            prev = curr;
        }

        return res.size();
    }
}