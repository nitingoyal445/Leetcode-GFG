class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] rArr = new int[heights.length]; // next smaller element to the right
        
        Stack<Integer> st = new Stack<>();
        st.push(heights.length-1);
        rArr[heights.length-1]=heights.length;
        for(int i=heights.length-2;i>=0;i--){
            while(st.size()>0 && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                rArr[i] = heights.length;
            }else{
                rArr[i] = st.peek();
            }
            st.push(i);
        }
        
        int[] lArr = new int[heights.length]; // next smaller element to the left
        st = new Stack<>();
        st.push(0);
        lArr[0] = -1;
        for(int i=1;i<heights.length;i++){
            while(st.size()>0 && (heights[i]<=heights[st.peek()])){
                st.pop();
            }
            if(st.size()==0){
                lArr[i] = -1;
            }else{
                lArr[i] = st.peek();
            }
            st.push(i);
        }
        
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int width = rArr[i] - lArr[i] - 1;
            int area = width * heights[i];
            if(area>maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}