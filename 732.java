class MyCalendarThree {
    private TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int max = 0, count = 0;
        
        for (int val : map.values()) {
            count += val;
            max = Math.max(max, count);
        }
        
        return max;
    }
}