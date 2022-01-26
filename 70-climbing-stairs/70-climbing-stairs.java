class Solution {
    public int climbStairs(int n) {
        // return climbMemo(n, new int[n+1]);
        return climbTabu(n);
    }
    
    public static int climbTabu(int n){
        int[] ans = new int[n+1];
        
        ans[0] = 1;
        for(int i=1;i<=n;i++){
            if(i==1){
                ans[i] = ans[i-1];
            }else{
                ans[i] = ans[i-1]+ans[i-2];
            }
        }
        return ans[n];
    }
    // public int climbMemo(int n, int[] qb){
    //     if(n==0){
    //         return 1;
    //     }
    //     else if(n<0){
    //         return 0;
    //     }
    //     if(qb[n]!=0){
    //         return qb[n];
    //     }
    //     int a = climbMemo(n-1, qb);
    //     int b = climbMemo(n-2, qb);
    //     qb[n] = a+b;
    //     return a+b;
    // }
    
}