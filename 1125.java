import java.util.*;

class Solution {

    public int[] smallestSufficientTeam(
        String[] req_skills,
        List<List<String>> people
    ) {

        int n = req_skills.length;

        // Map each skill to a bit index
        HashMap<String, Integer> skillMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            skillMap.put(req_skills[i], i);
        }

        // DP: skillMask -> team
        HashMap<Integer, List<Integer>> dp = new HashMap<>();

        dp.put(0, new ArrayList<>());

        for (int i = 0; i < people.size(); i++) {

            int personSkill = 0;

            // Create bitmask for current person
            for (String skill : people.get(i)) {

                if (skillMap.containsKey(skill)) {
                    personSkill |=
                        (1 << skillMap.get(skill));
                }
            }

            HashMap<Integer, List<Integer>> temp =
                new HashMap<>(dp);

            for (int mask : temp.keySet()) {

                int newMask = mask | personSkill;

                // New team formed
                List<Integer> team =
                    new ArrayList<>(temp.get(mask));

                team.add(i);

                // Update if smaller team found
                if (
                    !dp.containsKey(newMask)
                    || team.size()
                       < dp.get(newMask).size()
                ) {
                    dp.put(newMask, team);
                }
            }
        }

        int fullMask = (1 << n) - 1;

        List<Integer> ans = dp.get(fullMask);

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}