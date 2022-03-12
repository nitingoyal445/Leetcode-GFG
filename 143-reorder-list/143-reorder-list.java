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
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode middleNode1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next ==null || head.next.next==null){
            return;
        }
        //step1 - Segregate from middle
        ListNode mid = middleNode1(head);
        ListNode head2 = mid.next;
        mid.next = null;
        //step2 - Reverse second half
        head2 = reverseList(head2);
        //step3 - Merge them according to logic
        ListNode temp1 = head;
        ListNode temp2 = head2;
        
        while(temp1!=null && temp2!=null){
            ListNode next1 = temp1.next;
            ListNode next2 = temp2.next;
            
            temp1.next = temp2;
            temp2.next = next1;
            
            temp1 = next1;
            temp2 = next2;
            
        }
    }
}