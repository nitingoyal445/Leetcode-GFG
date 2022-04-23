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
    public int pairSum(ListNode head) {
        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);
        int max = 0;
        while(head2!=null){
            int a = head.val;
            int b = head2.val;
            if((a+b)>max){
                max = a+b;
            }
            System.out.println(head.val+"-->"+head2.val);
            head2 = head2.next;
            head=head.next;
        } 
        return max;
    }
    
    public ListNode findMid(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next.next!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head2){
        if(head2==null || head2.next==null){
            return head2;
        }
        ListNode prevNode = head2;
        ListNode currNode = head2.next;
        
        while(currNode!=null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            
            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head2.next = null;
        head2 = prevNode;
        return head2;
    }
}