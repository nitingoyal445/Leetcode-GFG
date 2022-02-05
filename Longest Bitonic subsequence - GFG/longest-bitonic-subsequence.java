// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Longest Increasing Susequence
    public static int[] LIS(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int ans = 1;
        for(int i=1;i<arr.length;i++){
            int max = 0;
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
            ans = Math.max(ans, dp[i]);
        }
        return dp;
    }
    //Longest Decreasing Susequence
    private static int[] LDS(int[] arr){
	    int[] dp = new int[arr.length];
	    dp[arr.length-1] = 1;
	    int ans = 1;
	    
	    for(int i=arr.length-2;i>=0;i--){
	        int max = 0;
	        for(int j=i+1;j<arr.length;j++){
	            if(arr[i]>arr[j]){
	                max = Math.max(max, dp[j]);
	            }
	        }
	        dp[i] = max + 1;
	        ans = Math.max(ans, dp[i]);
	    }
	    return dp;
	}
    public int LongestBitonicSequence(int[] arr)
    {
        int LIS_[] = LIS(arr);
        int LDS_[] = LDS(arr);
        
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            ans = Math.max(ans, LIS_[i]+LDS_[i]-1);
        }
        return ans;
    }
}