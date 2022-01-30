class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        long num = n;
        if((num&(num-1))==0){
            return true;
        }else{
            return false;
        }
    }
}