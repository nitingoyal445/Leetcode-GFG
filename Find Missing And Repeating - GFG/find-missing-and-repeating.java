// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int xor = 0;
   
        for(int val : arr){
           xor = xor ^ val;
        }
        for(int i=1;i<=arr.length;i++){
           xor = xor ^ i;
        }
        
        int rmsb = xor & -xor;
        
        int x = 0;
        int y = 0;
        
        for(int val : arr){
           if((rmsb&val) == 0){
               x = x ^ val;
           }else{
               y = y ^ val;
           }
        }
        for(int i=1;i<=arr.length;i++){
           if((rmsb&i) == 0){
               x = x ^ i;
           }else{
               y = y ^ i;
           }
        }
        int[] ans=new int[2];
        for(int val : arr){
           if(val == x){
                ans[0] = x;
                ans[1] = y;
               break;
           }else if(val == y){
                ans[0] = y;
                ans[1] = x;
               break;
           }
        }
        return ans;
    }
}