class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        
        for(int i=0;i<n;i++){
            for(char ch : words[i].toCharArray()){
                masks[i] |= 1 << (ch-'a');
            }
        }
        
        int largest = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((1!=j) && (masks[i] & masks[j])==0){
                    largest = Math.max(largest, (words[i].length() * words[j].length()));
                }
            }
        }
        return largest;
    }
    
    //explaination
    // https://leetcode.com/problems/maximum-product-of-word-lengths/discuss/2085333/Short-Bitmask-Solution-(explained)-or-JAVA
}