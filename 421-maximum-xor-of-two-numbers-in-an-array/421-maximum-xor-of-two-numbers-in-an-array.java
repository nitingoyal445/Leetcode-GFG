class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxLen = 0;
        for(int num : nums){
            maxLen = Math.max(maxLen, Integer.toBinaryString(num).length());
        }
        int mask = 0, maxRes = 0;
        for(int L=maxLen-1; L>=0; L--){
            mask = mask | (1<<L);
            Set<Integer> prefix = new HashSet<>();
            for(int num : nums){
                prefix.add(num & mask);
            }
            
            int currPrex = maxRes | (1<<L);
            for(int prex : prefix){
                if(prefix.contains(currPrex ^ prex)){
                    maxRes = currPrex;
                    break;
                }
            }
        }
        return maxRes;
    }
}
