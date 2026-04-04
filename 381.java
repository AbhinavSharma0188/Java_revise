import java.util.*;

class RandomizedCollection {
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    private Random rand;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val);
        map.putIfAbsent(val, new HashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        return notPresent;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) return false;
        int idx = map.get(val).iterator().next();
        map.get(val).remove(idx);
        
        int last = list.get(list.size() - 1);
        list.set(idx, last);
        
        map.get(last).add(idx);
        map.get(last).remove(list.size() - 1);
        
        list.remove(list.size() - 1);
        if (map.get(val).isEmpty()) map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}