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
    public int getDecimalValue(ListNode head) {
        int dec = 0;
        ListNode p = head;
        int n=0;
        while(p!=null)
        {
            n++;
            p = p.next;
        }
        p = head;
        int i = n-1;
        while(p!=null)
        {
            dec+= p.val*((int)(Math.pow(2, i)));
            p = p.next;
            i--;
        }
        return dec;
    }
}