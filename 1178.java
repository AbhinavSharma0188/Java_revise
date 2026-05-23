class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();

        for (String word : words) {
            int mask = 0;

            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }

            if (Integer.bitCount(mask) <= 7) {
                map.put(mask, map.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (String puzzle : puzzles) {
            int firstChar = 1 << (puzzle.charAt(0) - 'a');

            int mask = 0;
            for (char c : puzzle.toCharArray()) {
                mask |= 1 << (c - 'a');
            }

            int subMask = mask;
            int count = 0;

            while (subMask > 0) {
                if ((subMask & firstChar) != 0) {
                    count += map.getOrDefault(subMask, 0);
                }

                subMask = (subMask - 1) & mask;
            }

            result.add(count);
        }

        return result;
    }
}