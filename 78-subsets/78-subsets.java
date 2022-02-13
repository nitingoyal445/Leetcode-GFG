class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        getAllSubset(nums, 0, list, ans);
        return ans;
    }
    
    private void getAllSubset(int[] nums, int idx, List<Integer> curr, List<List<Integer>> ans){
        
        if(idx==nums.length){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        
        curr.add(nums[idx]);
        getAllSubset(nums, idx+1,curr, ans);
        curr.remove(curr.size()-1);
        getAllSubset(nums, idx+1,curr, ans);
        
    }
    
}