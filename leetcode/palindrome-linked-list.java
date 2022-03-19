/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    ListNode p;
    
    public boolean f(ListNode q)
    {
        if(q == null)
            return true;
        boolean res = f(q.next) && (p.val == q.val);
        p = p.next;
        return res;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if(head.next == null)
            return true;
        if(head.next.next == null)
            return head.val == head.next.val;
        
        while(fast != null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null)
            slow = slow.next;
        p = head;
        return f(slow);
    }
}