class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] arr1 = new int[nums.length/2];
        int[] arr2 = new int[nums.length/2];
        
        int j = 0;
        int k = 0;
        
        for(int val: nums){
            if(val<0){
                arr1[j++] = val;
            }else{
                arr2[k++] = val;
            }
        }
        j=0;
        k=0;
        int i = 0;
        int[] ans = new int[nums.length];
        while(j<arr1.length && k<arr2.length){
            ans[i++] = arr2[k++];
            ans[i++] = arr1[j++];
        }
        return ans;
    }
}