class Solution {
    public void wiggleSort(int[] nums) {
        
        //sort the array
        Arrays.sort(nums);
        //create new array and manage
        int n=nums.length;
        int[] res = new int[n];
        
        int i = 1;
        int j = n-1;
        while(i<n){
            res[i] = nums[j];
            i+=2;
            j--;
        }
        i=0;
        while(i<n){
            res[i] = nums[j];
            i+=2;
            j--;
        }
        
        //fill the result in input array
        for(int k=0;k<nums.length;k++){
            nums[k] = res[k];
        }
        
    }
}