// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<List<String>> Anagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();
		
		for(String str : strs){
		    HashMap<Character, Integer> fmap  = new HashMap<>();
		    for(int i=0;i<str.length();i++){
		        char ch = str.charAt(i);
		        fmap.put(ch, fmap.getOrDefault(ch, 0)+1);
		    }
		    
		    if(bmap.containsKey(fmap) == false){
		        ArrayList<String> list = new ArrayList<>();
		        list.add(str);
		        bmap.put(fmap,list);
		    }else{
		        ArrayList<String> list = bmap.get(fmap);
		        list.add(str);
		    }
		}
		List<List<String>> res = new ArrayList<>();
		for(ArrayList<String> list: bmap.values()){
		    res.add(list);
		}
		return res;
    }
}
