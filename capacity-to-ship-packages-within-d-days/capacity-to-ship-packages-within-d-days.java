class Solution {
    
    public boolean isWeigthPossible(int[] weights, int mid, int days){
        int requiredDays = 1;
        int weightSum = 0;
        
        for(int val : weights){
            weightSum+=val;
            if(weightSum > mid){
                requiredDays++;
                weightSum = val;
            }
        }
        return requiredDays <= days;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        
        int sum =0 ;
        int max = Integer.MIN_VALUE;
        for(int val : weights){
            max = Math.max(val,max);
            sum+=val;
        }
        
        int lo = max;
        int hi = sum;
        int capacity = Integer.MAX_VALUE;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(isWeigthPossible(weights, mid, days)){
                capacity = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return capacity;
    }
}