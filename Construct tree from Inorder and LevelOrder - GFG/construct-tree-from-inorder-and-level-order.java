// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    private Node constructInLevel(int[] in, int inSt, int inEnd, ArrayList<Integer> level){
        
        if(level.size()==0){
            return null;
        }
        Node root = new Node(level.get(0));
        int indx= inSt;
        HashSet<Integer> set = new HashSet<>();
        while(in[indx] != root.data){
            set.add(in[indx]);
            indx++;
        }
        ArrayList<Integer> llvl = new ArrayList<>();
        ArrayList<Integer> rlvl = new ArrayList<>();
        
        for(int i=1;i<level.size();i++){
            int val = level.get(i);
            if(set.contains(val)){
                llvl.add(val);
            }else{
                rlvl.add(val);
            }
        }
        root.left = constructInLevel(in, inSt, indx-1, llvl);
        root.right = constructInLevel(in, indx+1, inEnd, rlvl);
        return root;
        
    }
    Node buildTree(int in[], int level[])
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int val : level){
            list.add(val);
        }
        return constructInLevel(in, 0, in.length-1, list);
    }
    
   
}


