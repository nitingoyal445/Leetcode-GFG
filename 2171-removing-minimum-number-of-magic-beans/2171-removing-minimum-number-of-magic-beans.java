class Solution {
    public long minimumRemoval(int[] beans) {
        long sum = 0L;
        Arrays.sort(beans);
        long maxArea = 0;
        for(int i=0;i<beans.length;i++){
            sum+=beans[i];
            maxArea = Math.max(maxArea, beans[i]*1L*(beans.length-i));
        }
        return sum-maxArea;
    }
    // Logic- sorth the array then find largest area histogram then minus the value from summation of whole array
    
}