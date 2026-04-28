import java.util.*;

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            if (set.contains(curr.val) && 
               (curr.next == null || !set.contains(curr.next.val))) {
                count++;
            }
            curr = curr.next;
        }

        return count;
    }
}