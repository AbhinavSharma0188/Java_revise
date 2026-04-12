import java.util.*;

class AllOne {

    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Node head, tail;
    private Map<String, Node> map;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head.next.count == 1) {
                head.next.keys.add(key);
                map.put(key, head.next);
            } else {
                Node node = new Node(1);
                node.keys.add(key);
                insertAfter(head, node);
                map.put(key, node);
            }
        } else {
            Node curr = map.get(key);
            int newCount = curr.count + 1;
            if (curr.next.count == newCount) {
                curr.next.keys.add(key);
                map.put(key, curr.next);
            } else {
                Node node = new Node(newCount);
                node.keys.add(key);
                insertAfter(curr, node);
                map.put(key, node);
            }
            curr.keys.remove(key);
            if (curr.keys.isEmpty()) remove(curr);
        }
    }

    public void dec(String key) {
        Node curr = map.get(key);
        if (curr.count == 1) {
            map.remove(key);
        } else {
            int newCount = curr.count - 1;
            if (curr.prev.count == newCount) {
                curr.prev.keys.add(key);
                map.put(key, curr.prev);
            } else {
                Node node = new Node(newCount);
                node.keys.add(key);
                insertAfter(curr.prev, node);
                map.put(key, node);
            }
        }
        curr.keys.remove(key);
        if (curr.keys.isEmpty()) remove(curr);
    }

    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }

    private void insertAfter(Node prev, Node node) {
        node.next = prev.next;
        node.prev = prev;
        prev.next.prev = node;
        prev.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}