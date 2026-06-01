import java.util.LinkedList;

class CombinationIterator {
    private Queue<String> queue = new LinkedList<>();

    public CombinationIterator(String characters, int combinationLength) {
        generate(characters, combinationLength, 0, new StringBuilder());
    }

    private void generate(String chars, int len, int index, StringBuilder sb) {
        if (sb.length() == len) {
            queue.offer(sb.toString());
            return;
        }

        for (int i = index; i < chars.length(); i++) {
            sb.append(chars.charAt(i));
            generate(chars, len, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}