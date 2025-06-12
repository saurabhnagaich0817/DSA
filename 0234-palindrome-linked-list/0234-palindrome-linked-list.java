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
    public boolean isPalindrome(ListNode head) {
        ListNode f=head;
        ListNode s=head;
        while(f!=null && f.next!= null){
            f=f.next.next;
            s=s.next;

        }
            if( f!=null){
                s=s.next;
            }
            s=rev(s);
            f=head;
            while( s!=null){
                if(f.val !=s.val){
                    return false;
                }
                f=f.next;
                s=s.next;

            }
            return true;

    }
    public ListNode rev(ListNode head){
        ListNode p=null;
        ListNode c=head;
        ListNode t=null;
        while(c != null){
            t=c.next;
            c.next=p;
            p=c;
            c=t;

        }
        return p;
    }
}