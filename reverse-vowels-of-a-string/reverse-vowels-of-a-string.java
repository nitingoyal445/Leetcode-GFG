class Solution {
    public String reverseVowels(String s) {
        
        char[] arr = s.toCharArray();
        int left=0;
        int right=s.length()-1;
        
        // String vowels = "aeiouAEIOU";
        
        while(left < right){
            
            while(left< right && isVowel(arr[left]) == false){
                left++;
            }
            while(left< right && isVowel(arr[right]) == false){
                right--;
            }
            
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
        
        return String.copyValueOf(arr);
    }
    
    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){
            return true;
        }
        else if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ){
            return true;
        }
        else{
            return false;
        }
    }
}