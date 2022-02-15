class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
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
}