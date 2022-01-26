class Solution {
    public int climbStairs(int n) {
        return climbMemo(n, new int[n+1]);
    }
    public int climbMemo(int n, int[] qb){
        if(n==0){
            return 1;
        }
        else if(n<0){
            return 0;
        }
        if(qb[n]!=0){
            return qb[n];
        }
        int a = climbMemo(n-1, qb);
        int b = climbMemo(n-2, qb);
        qb[n] = a+b;
        return a+b;
    }
}