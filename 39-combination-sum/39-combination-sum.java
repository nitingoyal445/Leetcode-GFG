class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<Integer> list =new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        getAllCombinationSum(ans, list, candidates, 0, 0, target);
        return ans;
    }
    
    void getAllCombinationSum(List<List<Integer>> ans, List<Integer> list, int[] candidates,int idx,int sum, int target){
        if(target == sum){
            List<Integer> l = new ArrayList<>(list);
            ans.add(l);
            return;
        }
        else if(idx == candidates.length || sum > target){
            return;
        }
        
        for(int i=idx; i<candidates.length; i++){
            list.add(candidates[i]);
            getAllCombinationSum(ans, list, candidates, i, sum+candidates[i], target);
            list.remove(list.size()-1);
        }
    }
    
}