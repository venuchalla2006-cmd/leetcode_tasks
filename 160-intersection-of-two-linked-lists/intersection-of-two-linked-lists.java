class Solution { 

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) { 

        if (headA == null || headB == null) { 
            return null; 
        } 

        ListNode pA = headA; 
        ListNode pB = headB; 

        // Traverse both lists. When one pointer reaches the end,
        // redirect it to the other list's head.
        while (pA != pB) { 
            pA = (pA == null) ? headB : pA.next; 
            pB = (pB == null) ? headA : pB.next;  
        } 

        // Either both are null (no intersection), or both point to intersection node
        return pA; 
    } 
}
