class Solution {
    public int fib(int n) {
        return fibMemo(n,new int[n+1]);
    }
    public static int fibMemo(int n, int[] qb){
        if(n==1 || n==0 ){
            return n;
        }
        if(qb[n]!=0){
            return qb[n];
        }
        int a = fibMemo(n-1, qb);
        int b = fibMemo(n-2, qb);
        int sum = a+b;
        qb[n]=sum;
        return sum;
    }
}