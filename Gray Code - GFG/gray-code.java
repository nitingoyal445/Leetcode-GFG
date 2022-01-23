// { Driver Code Starts
//Initial Template for Java
//Initial Template for Java

//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList; 


 // } Driver Code Ends
//User function Template for Java

class Solution
{
    public ArrayList<String> graycode(int n)
    {
        if(n<=1){
 	        ArrayList<String> list = new ArrayList<>();
 	        list.add("0");
 	        if(n==1){
 	           list.add("1"); 
 	        }
 	        return list;
 	    }
 	    
 	    ArrayList<String> rlist = graycode(n-1);
 	    ArrayList<String> mres = new ArrayList<>();
 	    for(int i=0;i<rlist.size();i++){
 	         mres.add("0"+rlist.get(i));
 	    }
 	    for(int i=rlist.size()-1; i>=0; i--){
 	        mres.add("1"+rlist.get(i));
 	    }
 	    return mres;
    }
}

// { Driver Code Starts.

class BitWise
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			
			Solution obj = new Solution();
			
			ArrayList<String> ans=obj.graycode(n);
			for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
			    
			System.out.println();
            
            t--;
		}
	}
	
	
}
  // } Driver Code Ends