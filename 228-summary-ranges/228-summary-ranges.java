class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ans  = new ArrayList<>();
        String str = "";
        int count = 0;
        for(int i=0;i<nums.length;i++){
            str ="";
            count = 0;
            str += nums[i];
            while((i+1)<nums.length && nums[i+1] == (nums[i]+1)){
                i++;
                count++;
            }
            if(count>0){
                str+= "->"+nums[i];
            }
            ans.add(str);
        }
        return ans;
    }
}