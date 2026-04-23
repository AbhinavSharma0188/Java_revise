class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int size = length / k;
        int extra = length % k;

        ListNode[] result = new ListNode[k];
        curr = head;

        for (int i = 0; i < k; i++) {
            if (curr == null) {
                result[i] = null;
                continue;
            }

            result[i] = curr;
            int partSize = size + (extra > 0 ? 1 : 0);
            extra--;

            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }

            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        return result;
    }
}