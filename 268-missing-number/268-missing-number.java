class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = (nums.length*(nums.length+1))/2;
        for(int val : nums){
            expectedSum -= val;
        }
        return expectedSum;
    }
}