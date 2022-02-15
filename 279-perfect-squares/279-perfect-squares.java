class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            int min = Integer.MAX_VALUE;
            int count = 1;
            while(i - (count*count)>=0){
                min = Math.min(min, dp[i-count*count]);
                count++;    
            }
            dp[i] = min+1;
        }
        return dp[n];
    }
    
    // It's logic is to much same as LIS but this question is not a application of LIS.
}