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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode prev = new ListNode(0);
        ListNode res = prev;
        int c = 0;
        while(p1 != null && p2 != null)
        {
            int sum = p1.val + p2.val + c;
            int a = sum % 10;
            ListNode temp = new ListNode(a);
            prev.next = temp;
            prev = temp;
            c = sum/10;
            p1 = p1.next;
            p2 = p2.next;
        }
        while(p1 != null)
        {
            int sum = p1.val + c;
            int a = sum % 10;
            ListNode temp = new ListNode(a);
            prev.next = temp;
            prev = temp;
            c = sum/10;
            p1 = p1.next;
        }
        while(p2 != null)
        {
            int sum = p2.val + c;
            int a = sum % 10;
            ListNode temp = new ListNode(a);
            prev.next = temp;
            prev = temp;
            c = sum/10;
            p2 = p2.next;
        }
        if(c != 0)
        {
            ListNode temp = new ListNode(c);
            prev.next = temp;
        }
        return res.next;
    }
}