import java.util.*;

class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        List<Set<String>> sets = new ArrayList<>();

        for (List<String> list : favoriteCompanies) {
            sets.add(new HashSet<>(list));
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean subset = false;

            for (int j = 0; j < n && !subset; j++) {
                if (i == j || sets.get(j).size() < sets.get(i).size()) {
                    continue;
                }

                if (sets.get(j).containsAll(sets.get(i))) {
                    subset = true;
                }
            }

            if (!subset) {
                ans.add(i);
            }
        }

        return ans;
    }
}