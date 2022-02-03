// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to swap odd and even bits.
    public static int swapBits(int n) 
    {
	    int mask1 = 0x5_5_5_5_5_5_5_5;
        int mask2 = 0xA_A_A_A_A_A_A_A;
        
        int n1 = (n&mask1);
        int n2 = (n&mask2);
        
        n1 = (n1<<1);
        n2 = (n2>>1);
        
        int res = (n1|n2);
        
        return res;
	}
    
}

// { Driver Code Starts.

class BitWise{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//taking n
		    
		    Solution obj = new Solution();
		    
		    //calling swapBits() method of class
		    //Swap
		    System.out.println(obj.swapBits(n));
		}
	}
}  // } Driver Code Ends