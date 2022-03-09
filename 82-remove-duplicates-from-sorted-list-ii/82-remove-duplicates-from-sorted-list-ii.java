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
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val != cur.next.val){
                pre = cur;
                cur = cur.next;
            }else{
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                if(pre != null){
                     pre.next = cur.next;
                }else{
                    head = cur.next;
                }
                cur = cur.next;
            }
        }
        return head;
    }
}