class Solution {
    public String addStrings(String num1, String num2) {
        String res = "";
    int i=num1.length()-1;
    int j=num2.length()-1;
    int carry=0;
    
    while(i>=0 || j>=0 || carry!=0){
        int n1 = 0;
        int n2 = 0;
        if(i>=0){
            n1 = num1.charAt(i) - '0';
            i--;
        }
        if(j>=0){
            n2 = num2.charAt(j) - '0';
            j--;
        }
        int val = n1+n2+carry;
        carry = val/10;
        res = (val%10)+res;
    }
    return res;
    }
}