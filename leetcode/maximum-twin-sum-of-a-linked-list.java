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
    
    static ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode cur = head.next;
        ListNode prev = head;
        ListNode temp;
        while(cur!=null)
        {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        head.next = null;
        head = prev;
        return head;
    }
    
    public int pairSum(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode t1 = head;
        ListNode t2 = reverseList(slow);
        int max = 0;
        while(t2!= null)
        {
            int sum = t1.val + t2.val;
            max = Math.max(sum,max);
            t1 = t1.next;
            t2 = t2.next;
        }
        return max;
    }
}