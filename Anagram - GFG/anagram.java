// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}// } Driver Code Ends



class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String s1,String s2)
    {
       if(s1.length()!=s2.length()) return false;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s1.length();i++){
		    char ch = s1.charAt(i);
		    map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		for(int i=0;i<s2.length();i++){
		    char ch = s2.charAt(i);
		    if(map.containsKey(ch)==false) return false;
		    map.put(ch, map.get(ch) - 1);
		    if(map.get(ch) == 0){
		        map.remove(ch);
		    }
		}
		return map.size()==0;
    }
}