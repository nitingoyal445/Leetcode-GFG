class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] selected = new boolean[nums.length];
        findPermutation(nums, list, ans, selected);
        return ans;
    }
    
    public void findPermutation(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] selected){
        
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0;i<selected.length;i++){
            if(!selected[i]){
                selected[i] = true;
                list.add(nums[i]);
                findPermutation(nums, list, ans, selected);
                list.remove(list.size()-1);
                selected[i] = false;
            }
        }
        
    }
    
}