// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        int count=0;
        HashMap<String, Integer> map = new HashMap<>();
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        int delta10= countOne-countZero;
        int delta21 = countTwo-countOne;
        String key = delta10+"#"+delta21;
        map.put(key,1);
        
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0'){
                countZero++;
            }else if(str.charAt(i)=='1'){
                countOne++;
            }else{
                countTwo++;
            }
            delta10= countOne-countZero;
            delta21 = countTwo-countOne;
            key = delta10+"#"+delta21;
            if(map.containsKey(key)){
                count+=map.get(key);
            }
            map.put(key, map.getOrDefault(key,0)+1);
        }
        return count;
    }
} 