class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int xxory = 0;
        for(int val : nums){
            xxory = xxory ^ val;
        }
        
        int rmbm = xxory & -xxory;
        int x = 0;
        int y = 0;
        for(int val : nums){
            if((rmbm & val) == 0){
                x = x^val;
            }else{
                y = y^val;
            }
        }
        ans[0]=x;
        ans[1]=y;
        return ans;
    }
}