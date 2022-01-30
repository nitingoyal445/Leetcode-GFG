class Solution {
    public int findFinalValue(int[] nums, int original) {
        while (true){
            boolean flag = false;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==original){
                    flag=true;
                    original*=2;
                    break;
                }
            }
            if(flag==false){
                break;
            }
        }
        return original;
    }
}