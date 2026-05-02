class FreqStack {
    java.util.Map<Integer, Integer> freq;
    java.util.Map<Integer, java.util.Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        freq = new java.util.HashMap<>();
        group = new java.util.HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (f > maxFreq) maxFreq = f;
        group.computeIfAbsent(f, k -> new java.util.Stack<>()).push(val);
    }
    
    public int pop() {
        int val = group.get(maxFreq).pop();
        freq.put(val, freq.get(val) - 1);
        if (group.get(maxFreq).isEmpty()) maxFreq--;
        return val;
    }
}