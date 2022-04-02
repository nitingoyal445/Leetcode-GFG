class Solution {
    
    public boolean checkValidPalindrome(String s, int left, int right, int count){
        if(count>1){
            return false;
        }
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
               return checkValidPalindrome(s, left+1, right, count+1) || checkValidPalindrome(s, left, right-1, count+1);
            }
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        return checkValidPalindrome(s, left, right, 0);
    }
}