class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        
        int sum = 0;
        for(int val : nums){
            sum+=val;
        }
        List<Integer> list = new ArrayList<>();
        int max = sum;
        list.add(0);
        
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]==1){
                sum--;
            }
            if(nums[i-1]==0){
                sum++;
            }
            
            if(sum>max){
                max= sum;
                list.clear();
                list.add(i);
            }else if(sum == max){
                list.add(i);
            }
            
        }
        return list;
    }
}