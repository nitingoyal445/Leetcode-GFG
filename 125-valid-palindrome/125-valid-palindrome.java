class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==1){
            return true;
        }
        s = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;
        
        while(l<r){
            char ch1 = s.charAt(l);
            if((ch1>=97 && ch1<=122) || (ch1>=48 && ch1<=57)){
                
            }else{
                l++;
                continue;
            }
            char ch2 = s.charAt(r);
            if((ch2>=97 && ch2<=122) || (ch2>=48 && ch2<=57)){
                
            }else{
                r--;
                continue;
            }
            
            if(ch1!=ch2){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}