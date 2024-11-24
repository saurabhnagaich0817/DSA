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
    public ListNode swapPairs(ListNode head) {
        
        if(head==null||head.next==null){
            return head;
        }
        ListNode o=head;
        ListNode e=o.next;
        while(e!=null && o!=null){
            int t=o.val;
            o.val=e.val;
            e.val=t;
            if(e!=null){
                o=e.next;
            }
            if(o!=null){
                e=o.next;
            }
    }
            return head;
        }
}