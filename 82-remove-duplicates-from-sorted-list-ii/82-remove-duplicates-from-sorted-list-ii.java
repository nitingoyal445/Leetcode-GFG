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
        if(head == null) return head;
        ListNode head2 = new ListNode(-1);
        ListNode i = head2;
        ListNode curr = head;
        i.next = curr;
        
        while(curr!=null){
            
            curr = curr.next;
            boolean flag = false;
            while(curr!=null && i.next.val == curr.val){
                flag = true;
                curr = curr.next;
            }
            
            if(flag){
                i.next = curr;
            }else{
                i = i.next;
            }
        }
        return head2.next;
    }
}