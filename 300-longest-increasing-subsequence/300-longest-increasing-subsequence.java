class Solution {
    public int lengthOfLIS(int[] arr) {
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
        return ans;
    }
}