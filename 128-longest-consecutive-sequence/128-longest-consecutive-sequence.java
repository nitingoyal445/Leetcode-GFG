class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        
        int longest = 1;
        int temp = 1;
        // int val = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i]==(nums[i-1]+1)){
                temp++;
                longest = temp>longest?temp:longest;
            }else{
                temp=1;
            }
        }
        return longest;
    }
}