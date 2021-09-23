class Solution {
    public int minimumLength(String s) {
        int left=0;
        int right = s.length()-1;
        
        while(left < right && s.charAt(left) == s.charAt(right)){
            char c = s.charAt(left);
            
            //move left ahead with same character's present
            while(left <= right && s.charAt(left)== c){
                left++;
            }
            //move right backward with same character's present
            while(left <= right && s.charAt(right) == c){
                right--;
            }
        }
        
        return right-left+1;
    }
}