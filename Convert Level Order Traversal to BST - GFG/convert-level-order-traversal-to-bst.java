// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class GFG 
{
    public Node counstructBST_lvl(ArrayList<Integer> list){
        
        if(list.size()==0){
            return null;
        }
        Node root = new Node(list.get(0));
        ArrayList<Integer> llvl = new ArrayList<>();
        ArrayList<Integer> rlvl = new ArrayList<>();
        
        for(int i=1;i<list.size();i++){
            int val = list.get(i);
            if(val < root.data){
                llvl.add(val);
            }else{
                rlvl.add(val);
            }
        }
        
        root.left = counstructBST_lvl(llvl);
        root.right = counstructBST_lvl(rlvl);
        return root;
    }
    
    
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int val : arr){
            list.add(val);
        }
        return counstructBST_lvl(list);
    }
}