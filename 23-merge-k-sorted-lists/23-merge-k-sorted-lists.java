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
        int li;
        ListNode node;
        int val;
        
        Pair(int li, ListNode node, int val){
            this.li = li;
            this.node = node;
            this.val = val;
        }
        public int compareTo(Pair O){
            return this.val-O.val;
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
            if(lists[i]==null){
                continue;
            }
            Pair p = new Pair(i,lists[i],lists[i].val);
            pq.add(p);
        }
        if(pq.size()==0){
            ListNode node=null;
            return node;
        }
        while(pq.size()>0){
            Pair p = pq.remove();
            // System.out.println(p.val);
            temp.val=p.val;
            if(pq.size()!=0 || p.node.next!=null){
                ListNode t = new ListNode();
                temp.next = t;
                temp=temp.next;
            }
            p.node=p.node.next;
            if(p.node!=null){
                p.val = p.node.val;
                pq.add(p);
                
            }
        }
        return head;
    }
}
                   