class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] dp = new int[grid.length][grid[0].length];
        
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                
                int min = 0;
                if((i+1)<dp.length && (j+1)<dp[0].length){
                    min = Math.min(dp[i+1][j],dp[i][j+1]);
                }else if((i+1)<dp.length){
                    min = dp[i+1][j];
                }else if((j+1)<dp[0].length){
                    min = dp[i][j+1];
                }
                dp[i][j] = grid[i][j]+min;
            }
        }
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        
        return dp[0][0];
        
    }
}