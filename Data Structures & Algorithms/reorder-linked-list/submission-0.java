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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null&& fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode dummy = Reverse(slow.next);
        slow.next = null;
        ListNode first = head;
        
        while(dummy != null){
            ListNode fnext = first.next;
            ListNode snext = dummy.next;
            
            first.next = dummy;
            dummy.next = fnext;

            first = fnext;
            dummy = snext;
        }
    }
    public ListNode Reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
