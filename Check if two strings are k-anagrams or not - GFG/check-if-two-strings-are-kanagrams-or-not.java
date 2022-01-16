// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
class GFG {
    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
    	int t=sc.nextInt();
    	while(t-->0)
    	{
    		String str1=sc.next();
    		String str2=sc.next();
    		int k=sc.nextInt();
            Solution ob = new Solution();
    		if (ob.areKAnagrams(str1, str2, k) == true)
    			System.out.println("1");
    		else
    			System.out.println("0");
    	}
    }
}// } Driver Code Ends


//User function template for JAVA

class Solution {
    boolean areKAnagrams(String str1, String str2, int k) {
        if(str1.length()!=str2.length()){
		    return false;
		}
		int count=0;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str1.length();i++){
		    char ch = str1.charAt(i);
		    map.put(ch, map.getOrDefault(ch, 0) +1);
		}
		
		for(int i=0;i<str2.length();i++){
		    char ch = str2.charAt(i);
		    if(map.containsKey(ch)){
		        if(map.get(ch)==1){
		            map.remove(ch);
		        }else{
		            map.put(ch, map.get(ch)-1);
		        }
		    }
		}
		
		for(Character ch:map.keySet()){
		    count+=map.get(ch);
		}

		return count<=k;
    }
}