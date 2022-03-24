// { Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG();
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG
{
    static int index=0;
    public static Node constructBST_post(int[] post, int leftRange, int rightRange){
        if(index<0 || post[index]<leftRange || post[index]>rightRange){
            return null;
        }
        int val = post[index--];
        Node root= new Node(val);
        root.right = constructBST_post(post, val, rightRange);
        root.left = constructBST_post(post, leftRange, val);
        return root;
    }
    
    public static Node constructTree(int post[],int n)
    {
        index=post.length-1;
        return constructBST_post(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}