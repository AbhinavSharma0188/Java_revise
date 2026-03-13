public class LEETCODE_876 {
    // Making ListNode static allows us to use it inside the static main method
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;   
    }

    // Add exactly this method to make the program runnable
    public static void main(String[] args) {
        // 1. Create an instance of your class
        LEETCODE_876 solution = new LEETCODE_876();

        // 2. Create a test linked list: [1 -> 2 -> 3 -> 4 -> 5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 3. Call your method
        ListNode middle = solution.middleNode(head);

        // 4. Print the result (should print 3 for this test case)
        if (middle != null) {
            System.out.println("The middle node value is: " + middle.val);
        } else {
            System.out.println("The list is empty.");
        }
    }
}
