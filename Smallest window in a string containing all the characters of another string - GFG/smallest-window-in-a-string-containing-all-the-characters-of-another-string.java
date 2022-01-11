// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s1, String s2)
    {
        String ans = "";
		
		HashMap<Character, Integer> map2 = new HashMap<>();
		for(int i=0;i<s2.length();i++){
		    char ch = s2.charAt(i);
		    map2.put(ch, map2.getOrDefault(ch,0)+1);
		}
		int mct=0; //Match Count
		int dmct=s2.length(); // desired Match Count
		HashMap<Character, Integer> map1 = new HashMap<>();
		
		int i = -1;
		int j = -1;
		while(true){
		    boolean flag1 = false;
		    boolean flag2 = false;
		    //acquire
		    while(i<s1.length()-1 && mct<dmct){
		        i++;
		        char ch = s1.charAt(i);
		        map1.put(ch, map1.getOrDefault(ch,0)+1);
		        
		        if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0)){
		            mct++;
		        }
		        flag1 = true;
		    }
		    
		    //collect answers and release
		    while(j<i && mct==dmct){
		        String pans = s1.substring(j+1,i+1);
		        if(ans.length()==0 || pans.length()<ans.length()){
		            ans = pans;
		        }
		        j++;
		        char ch = s1.charAt(j);
		        if(map1.get(ch)==1){
		            map1.remove(ch);
		        }else{
		            map1.put(ch, map1.get(ch)-1);
		        }
		        
		        if(map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0)){
		            mct--;
		        }
		        flag2 = true;
		    }
		    if(flag1 == false || flag2 == false){
		        break;
		    }
		}
		
		return ans.length()>0?ans:"-1";
    }
}