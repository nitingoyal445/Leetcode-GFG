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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode i = head;
        ListNode curr = head.next;
        
        while(curr!=null){
            if(i.val!=curr.val){
                i.next = curr;
                i = curr;
            }
            curr = curr.next;
        }
        i.next = null;
        return head;
    }
}