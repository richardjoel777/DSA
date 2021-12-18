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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode f = head;
        ListNode s = head;
        ListNode prev = f;
        if(f.next==null)
            return null;
        for(int i=0;i<n-1;i++)
        {
            s = s.next;
        }
        if(s.next == null)
        {
            head = head.next;
            return head;
        }
        while(s.next!=null)
        {
            prev = f;
            f = f.next;
            s = s.next;
        }
        prev.next = f.next;
        return head;
    }
}