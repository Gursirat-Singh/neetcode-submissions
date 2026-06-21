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
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode add = new ListNode(-1);
        ListNode dummy = add;
        int carry = 0;
        while(n1 != null || n2 != null || carry != 0){
            int x,y;
            x = (n1!=null)?n1.val:0;
            y = (n2!=null)?n2.val:0;
            int sum = x + y + carry;
            carry = sum/10;
            sum %= 10;
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            n1 = (n1!=null)?n1.next:null;
            n2 = (n2!=null)?n2.next:null;
        }
        if(carry!=0){
            dummy.next = new ListNode(carry);
        }
        return add.next;
    }
}
