class Solution {
    public int removeDuplicates(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int k=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])<2){
                    map.put(nums[i],map.get(nums[i])+1);
                    k++;
                    nums[j++]=nums[i];
                }
            }else{
                map.put(nums[i],1);
                k++;
                nums[j++]=nums[i];
            }
        }
        return k;
    }
}