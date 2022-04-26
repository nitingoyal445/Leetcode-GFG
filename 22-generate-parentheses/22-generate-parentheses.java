class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        getAllParanthesis(ans, "", 0, 0, n);
        return ans;
    }
    
    private void getAllParanthesis(List<String> ans, String str, int open, int close, int max){
        if(str.length() == max*2){
            ans.add(str);
            return;
        }
        if(open<max){
            getAllParanthesis(ans, str+"(", open+1, close, max);
        }
        if(close<open){
            getAllParanthesis(ans, str+")", open, close+1, max);
        }
    }
}