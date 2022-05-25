class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == ')' && i-1 >= 0){                           //read dp[i-1] to get index of "(" related to ")" in this position
                int checkLeftIndex = i - dp[i-1] - 1;
                if(checkLeftIndex >= 0 && s.charAt(checkLeftIndex) == '('){
                    dp[i] = dp[i-1] + 2;                                          //case "(( ))" , dp = {0,0,2,2+2}
                    if(checkLeftIndex - 1 >= 0){
                        dp[i] += dp[checkLeftIndex - 1];                //Case"() (())", dp = {0,2,0,0,2,2+2+2}
                    }
                    ans = Math.max(ans,dp[i]);
                }
            }
        }
        return ans;
    }
}