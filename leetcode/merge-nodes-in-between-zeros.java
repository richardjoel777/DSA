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
    public ListNode mergeNodes(ListNode head) {
        ListNode p = head;
        while(p!=null)
        {
            if(p.val == 0)
            {
                ListNode t = p;
                int sum = 0;
                p = p.next;
                while(p!=null && p.val > 0)
                {
                    sum+= p.val;
                    p = p.next;
                }
                t.val = sum;
                if(p == null || p.next == null)
                    t.next = null;
                else
                    t.next = p;
            }
        }
        return head;
    }
}