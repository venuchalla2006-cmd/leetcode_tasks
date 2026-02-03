class Solution { 

    public ListNode reverseKGroup(ListNode head, int k) { 

        if (head == null || k == 1) { 
            return head; 
        } 

        ListNode dummy = new ListNode(0); 
        dummy.next = head; 
        ListNode prevGroupEnd = dummy; 

        while (true) { 
            ListNode kth = prevGroupEnd; 

            // Find the k-th node ahead
            for (int i = 0; i < k && kth != null; i++) { 
                kth = kth.next; 
            } 

            if (kth == null) { 
                break; 
            } 

            ListNode groupStart = prevGroupEnd.next; 
            ListNode curr = groupStart.next; 

            // Reverse nodes in the current group
            for (int i = 1; i < k; i++) { 
                groupStart.next = curr.next; 
                curr.next = prevGroupEnd.next; 
                prevGroupEnd.next = curr; 
                curr = groupStart.next; 
            } 

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart; 
        } 

        return dummy.next; 
    } 
}
