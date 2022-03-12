/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    private Map<Node, Node> nodeMap = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        nodeMap.clear();
        
        return buildList(head);
    }
        
    private Node buildList(Node node) {
        if(node == null)
            return null;
        
        Node newNode = new Node(node.val);
        nodeMap.put(node, newNode);
        newNode.next = buildList(node.next);
        newNode.random = nodeMap.get(node.random);
        return newNode;
    }
}