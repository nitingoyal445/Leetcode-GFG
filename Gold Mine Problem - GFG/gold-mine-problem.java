// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int grid[][])
    {
        int[][] dp = new int[n][m];
        
        for(int i=0;i<n;i++){
            dp[i][m-1]=grid[i][m-1];
        }
        
        for(int j=m-2;j>=0;j--){
            for(int i=0;i<n;i++){
                int max = dp[i][j+1];
                if((i-1)>=0){
                    max = Math.max(max, dp[i-1][j+1]);
                }if((i+1)<n){
                    max = Math.max(max, dp[i+1][j+1]);
                }
                dp[i][j] = max + grid[i][j];
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }
}