class Skiplist {

    class Node {

        int val;
        Node right;
        Node down;

        Node(int val, Node right, Node down) {
            this.val = val;
            this.right = right;
            this.down = down;
        }
    }

    Node head;

    Random random;

    public Skiplist() {

        head = new Node(-1, null, null);

        random = new Random();
    }

    public boolean search(int target) {

        Node curr = head;

        while (curr != null) {

            while (curr.right != null && curr.right.val < target) {
                curr = curr.right;
            }

            if (curr.right != null && curr.right.val == target) {
                return true;
            }

            curr = curr.down;
        }

        return false;
    }

    public void add(int num) {

        List<Node> stack = new ArrayList<>();

        Node curr = head;

        while (curr != null) {

            while (curr.right != null && curr.right.val < num) {
                curr = curr.right;
            }

            stack.add(curr);

            curr = curr.down;
        }

        boolean insertUp = true;

        Node downNode = null;

        while (insertUp && !stack.isEmpty()) {

            Node prev = stack.remove(stack.size() - 1);

            prev.right = new Node(num, prev.right, downNode);

            downNode = prev.right;

            insertUp = random.nextBoolean();
        }

        if (insertUp) {
            head = new Node(-1, new Node(num, null, downNode), head);
        }
    }

    public boolean erase(int num) {

        Node curr = head;

        boolean found = false;

        while (curr != null) {

            while (curr.right != null && curr.right.val < num) {
                curr = curr.right;
            }

            if (curr.right != null && curr.right.val == num) {

                found = true;

                curr.right = curr.right.right;
            }

            curr = curr.down;
        }

        return found;
    }
}