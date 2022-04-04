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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode fast = head;
        ListNode one = head;
        int n=k-1;
        while(n-->0){
            fast = fast.next;
        }
        one = fast;
        
        ListNode slow = head;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode two = slow;
        
        int temp = slow.val;
        slow.val = one.val;
        one.val = temp;
        
        return head;
    }
}