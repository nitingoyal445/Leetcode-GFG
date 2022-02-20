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
    public ListNode mergeNodes(ListNode head) {
        
        int sum = 0;
        ListNode temp = head.next;
        ListNode ll= new ListNode();
        ListNode pointer = ll;
        while(temp!=null){
            while(temp.val!=0){
                sum+=temp.val;
                temp = temp.next; 
            }
            ListNode newLL = new ListNode(sum);
            pointer.next = newLL;
            pointer = pointer.next;
            temp = temp.next;
            sum =0;
        }
        return ll.next; 
    }
}