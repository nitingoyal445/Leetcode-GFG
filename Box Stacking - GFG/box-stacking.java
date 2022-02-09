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
            String[] s1 = br.readLine().trim().split(" ");
            int[] height = new int[n];
            for(int i = 0; i < n; i++){
                height[i] = Integer.parseInt(s1[i]);
            }
            String[] s2 = br.readLine().trim().split(" ");
            int[] width = new int[n];
            for(int i = 0; i < n; i++){
                width[i] = Integer.parseInt(s2[i]);
            }
            String[] s3 = br.readLine().trim().split(" ");
            int[] length = new int[n];
            for(int i = 0; i < n; i++){
                length[i] = Integer.parseInt(s3[i]);
            }
            Solution obj = new Solution();
            System.out.println(obj.maxHeight(height, width, length, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    private static class Box implements Comparable<Box>{
        int l;
        int b;
        int h;
        int area;
        
        Box(int l, int b, int h){
            this.l = l;
            this.b = b;
            this.h = h;
            this.area = l*b;
        }
        
        public int compareTo(Box o){
            return o.area-this.area;
        }
        
    }
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        Box[] arr = new Box[3*n];
        int j = 0;
        for(int i=0;i<n;i++){
            
            //LBH
            if(length[i]>width[i]){
                arr[j++] = new Box(length[i], width[i], height[i]);
            }else{
                arr[j++] = new Box(width[i], length[i], height[i]);
            }
            //HBL
            if(height[i]>width[i]){
                arr[j++] = new Box(height[i], width[i], length[i]);
            }else{
                arr[j++] = new Box(width[i], height[i], length[i]);
            }
            
            //LHB
            if(length[i]>height[i]){
                arr[j++] = new Box(length[i], height[i], width[i]);
            }else{
                arr[j++] = new Box(height[i], length[i], width[i]);
            }
        }
        Arrays.sort(arr);
        
        int[] dp = new int[arr.length];
        dp[0] = arr[0].h;
        int maxHeight = dp[0];
        for(int i=0;i<dp.length;i++){
            int max = 0;
            for(int k=i-1;k>=0;k--){
                if(arr[k].l>arr[i].l && arr[k].b > arr[i].b){
                    max = Math.max(max, dp[k]);
                }
            }
            dp[i] = max+arr[i].h;
            maxHeight = Math.max(maxHeight,dp[i]);
        }
        return maxHeight;
    }
}