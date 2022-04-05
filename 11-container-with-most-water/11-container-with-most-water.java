class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int areaMax = Integer.MIN_VALUE;
        while(left<right){
            int area = Math.min(height[left], height[right]) * (right-left);
            if(area>areaMax){
                areaMax = area;
            }
            if(height[left]< height[right]){
                left++;
            }else{
                right--;
            }
        }
        return areaMax;
    }
}