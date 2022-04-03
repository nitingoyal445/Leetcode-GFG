class Solution {
    
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void nextPermutation(int[] nums) {
        if(nums.length ==1){
            return;
        }
        int i=nums.length-1;
        
        while(i>0 && nums[i-1]>=nums[i]){
            i--;
        }
        if(i>0){
            int curr_index = i-1;
            int j = nums.length-1;
            while(j>i && nums[j]<=nums[curr_index]) j--;
            swap(nums, curr_index, j);
        }
        int low = i;
        int high = nums.length-1;
        while(low<high){
            swap(nums, low, high);
            low++;
            high--;
        }
    }
}