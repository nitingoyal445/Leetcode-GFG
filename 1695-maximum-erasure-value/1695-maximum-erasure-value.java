class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        HashMap<Integer ,Integer> map= new HashMap<>();
        
        int i=1;
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int maxScore = nums[0];
        int sum = nums[0];
        map.put(nums[0],0);
        int j = 0;
        while(i<nums.length){
            arr[i] = arr[i-1]+nums[i];
            if(map.containsKey(nums[i])){
                j=Math.max(j, map.get(nums[i]));
                sum = arr[i]-arr[j];
            }else{
                sum+=nums[i]; 
            }
            map.put(nums[i], i);
            maxScore = sum>maxScore? sum:maxScore;
            i++;
        }
        return maxScore;
    }
}