/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
//     public ListNode detectCycle(ListNode head) { //leetcode 142
//         ListNode slow=head;
//         ListNode fast=head;
        
//         while(fast!=null && fast.next!=null){
//             slow = slow.next;
//             fast = fast.next.next;
//             if(slow == fast){
//                 break;
//             }
//         }
//         if(fast == null || fast.next==null) return null;
        
//         slow = head;
//         while(slow!=fast){
//             slow = slow.next;
//             fast = fast.next;
//         }
//         return slow;
//     }
//     //Using Floyd Cycle Method
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         //step-1: find tail and connect tail.next = headA
//         ListNode tailA = headA;
//         while(tailA.next!=null){
//             tailA = tailA.next;
//         }
//         tailA.next = headA;
        
//         //step-2: find starting node of cycle linkedlist(if cycle then result is node otherwise null)
//         ListNode res = detectCycle(headB);
        
//         //step-3: return original structure, tail.next= null
//         tailA.next = null;
        
//         //step-4:return result
//         return res;
//     }
    
    
    public static int size(ListNode head){
        if(head==null) return 0;
        ListNode curr = head;
        int count=1;
        while(curr!=null){
            curr = curr.next;
            count++;
        }
        return count;
    }
    //Using Differnce Method
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1 = size(headA);
        int size2 = size(headB);
        ListNode tempA = headA;
        ListNode tempB = headB;
        if(size1>size2){
            for(int i=0;i<size1-size2;i++){
                tempA = tempA.next;
            }
        }else{
            for(int i=0;i<size2-size1;i++){
                tempB = tempB.next;
            }
        }
        
        while(tempA!=null){
            if(tempA ==tempB){
                return tempA;
            }
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return null;
    }
}