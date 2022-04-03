class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        int i = n - 2;
        
        //Scan for the first decreasing number from right;
        while(i >= 0 && nums[i + 1] <= nums[i]){
            i--;
        }
        
        //If found, find the just greater number from the smaller number;
        if(i >= 0){
            int j = n-1;
            
            while(nums[j] <= nums[i]){
                j--;
            }
            
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        //Reverse the numbers after the swapped number;
        int st = i + 1;
        int ed = n - 1;
        
        while(st < ed){
            int temp = nums[st];
            nums[st] = nums[ed];
            nums[ed] = temp;
            
            st++;
            ed--;
        }
    }
}
