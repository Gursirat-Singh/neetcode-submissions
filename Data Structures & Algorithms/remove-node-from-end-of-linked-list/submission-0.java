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
        int size = 1;
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
            size++;
        }
        if(n==size){
            head = head.next;
            return head;
        }else{
            temp = head;
            int loop = size - n;
            for(int i = 0;i<loop-1;i++){
                temp = temp.next;
            }
            if(temp.next.next!=null){
                temp.next = temp.next.next;
            }else{
                temp.next = null;
            }
        }
        return head;
    }
}
