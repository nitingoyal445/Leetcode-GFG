class Solution {
    
    private boolean isPossible(int[] nums,int threshold,int mid){
        int time = 0;
        for(int i=0;i<nums.length;i++){
            time+=(int)Math.ceil(nums[i]*1.0 / mid);
        }
        return time<=threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }
        int lo = 1;
        int hi = max;
        int k = Integer.MAX_VALUE;
        
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            
            if(isPossible(nums, threshold, mid) == true){
                k = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return k;
    }
}