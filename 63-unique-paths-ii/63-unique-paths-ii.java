class Solution {
   
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[row-1][col-1]==1){
            return 0;
        }
        int[][] dp = new int[row][col];
        dp[0][0]=1;
        boolean flag = false;
        
        //fill first row
        for(int i=0;i<col;i++){
            if(flag || obstacleGrid[0][i]==1){
                flag = true;
                dp[0][i]=0;
            }else{
                dp[0][i]=1;
            }
        }
        
        //fill first column
        flag= false;
        for(int i=0;i<row;i++){
            if(flag || obstacleGrid[i][0]==1){
                flag = true;
                dp[i][0]=0;
            }else{
                dp[i][0]=1;
            }
        }
        
        //fill rest of the boxes row by row
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        
        return dp[row-1][col-1];
    }
    
}