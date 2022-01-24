class Solution {
    public boolean detectCapitalUse(String word) {
        
        int count = 0;
        for(char ch : word.toCharArray()){
            if(checkCapital(ch)){
                count++;
            }
        }
        
        if(count == 0 || count == word.length()){
            return true;
        }else if(count ==1){
            if(checkCapital(word.charAt(0))){
                return true;
            }
        }
        return false;
    }
    
    private static boolean checkCapital(char ch){
        if(ch>='A' && ch<='Z'){
            return true;
        }
        return false;
    }
}