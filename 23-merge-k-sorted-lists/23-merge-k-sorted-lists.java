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
    
    class Pair implements Comparable<Pair>{
        ListNode node;
        
        Pair(ListNode node){
            this.node = node;
        }
        public int compareTo(Pair O){
            return this.node.val-O.node.val;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length==0){
            ListNode node=null;
            return node;
        }
        
        ListNode head = new ListNode();
        ListNode temp = head;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(new Pair(lists[i]));
            }
        }
        if(pq.size()==0){
            ListNode node=null;
            return node;
        }
        while(pq.size()>0){
            Pair rem = pq.remove();
            temp.next=rem.node;
            temp = temp.next;
            if(rem.node.next!=null){
                pq.add(new Pair(rem.node.next));
            }
        }
        return head.next;
    }
}
                   