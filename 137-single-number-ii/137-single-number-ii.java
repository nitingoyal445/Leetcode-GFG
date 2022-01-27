class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<32;i++){
            int count = 0;
            int bm = (1<<i);
            for(int val : nums){
                if((val&bm)==bm){
                    count++;
                }
            }
            if(count%3==1){
                res = res | bm;
            }
        }
        return res;
    }
}