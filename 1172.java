class DinnerPlates {

    private int capacity;
    private List<Stack<Integer>> stacks;
    private PriorityQueue<Integer> available;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
        available = new PriorityQueue<>();
    }

    public void push(int val) {
        while (!available.isEmpty() &&
               available.peek() < stacks.size() &&
               stacks.get(available.peek()).size() == capacity) {
            available.poll();
        }

        if (available.isEmpty()) {
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            stacks.add(stack);

            if (capacity > 1) {
                available.offer(stacks.size() - 1);
            }
        } else {
            int idx = available.peek();
            stacks.get(idx).push(val);

            if (stacks.get(idx).size() == capacity) {
                available.poll();
            }
        }
    }

    public int pop() {
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }

        if (stacks.isEmpty()) {
            return -1;
        }

        return popAtStack(stacks.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty()) {
            return -1;
        }

        available.offer(index);
        return stacks.get(index).pop();
    }
}