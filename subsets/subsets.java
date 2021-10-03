class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        
        rec(nums, 0, curr , ans);
        return ans;
        
    }
    
    private void rec(int[] nums, int i, List<Integer> curr, List<List<Integer>> ans){
        if(i==nums.length){
            ans.add(new ArrayList<Integer> (curr));
            return;
        }
        curr.add(nums[i]);
        rec(nums,i+1,curr, ans);
        curr.remove(curr.size()-1);
        rec(nums,i+1,curr,ans);
    }
        
}