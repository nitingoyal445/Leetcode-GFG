// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str).length());
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public String findSubString( String str) {
        // Your code goes here
        String ans = "";
		HashSet<Character> set = new HashSet<>();
		for(int i =0;i<str.length();i++){
		    char ch = str.charAt(i);
		    set.add(ch);
		}
		int i=-1;
		int j=-1;
		HashMap<Character, Integer> map = new HashMap<>();
		while(true){
		    boolean f1 = false;
		    boolean f2 = false;
		    //Acquire
		    while(i<str.length()-1 && map.size()<set.size()){
		        i++;
		        char ch = str.charAt(i);
		        map.put(ch, map.getOrDefault(ch,0)+1);
		        f1 = true;
		    }
		    //Collect Answer and Release
		    while(j<i && map.size()==set.size()){
                String pans = str.substring(j+1,i+1);
                if(ans.length()==0 || pans.length()<ans.length()){
                    ans = pans;
                }
		        j++;
		        char ch = str.charAt(j);
		        if(map.get(ch)==1){
		            map.remove(ch);
		        }else{
		            map.put(ch, map.get(ch)-1);
		        }
		        f2=true;
		    }
		    if(f1==false || f2==false){
		        break;
		    }
		}
		return ans;
    }
}