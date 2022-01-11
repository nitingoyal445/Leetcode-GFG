// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String str){
        int ans = 0;
		
		HashMap<Character, Integer> map = new HashMap<>();
		int i = -1;
		int j = -1;
		
		while(true){
		    boolean f1 = false;
		    boolean f2 = false;
		    //Acquire
		    while(i<str.length()-1){
		        f1 = true;
		        i++;
		        char ch = str.charAt(i);
		        map.put(ch, map.getOrDefault(ch,0)+1);
		        
		        if(map.get(ch)==2){
		            break;
		        }else{
		            int len = i-j;
		            ans = len>ans?len:ans;
		        }
		    }
		    //Release
		    while(j<i){
		        f2 = true;
		        j++;
		        char ch = str.charAt(j);
		        map.put(ch,map.get(ch)-1);
		        if(map.get(ch)==1){
		            break;
		        }
		    }
		    if(f1 == false && f2 == false){
		        break;
		    }
		}
		
		return ans;
        
    }
}