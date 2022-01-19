class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length<=1){
            return true;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        
        for(int val:arr){
            min = Math.min(val, min);
            max = Math.max(val, max);
            set.add(val);
        }
        
        int cd = (max-min)/(arr.length-1); //common difference
        
        for(int i=0;i<arr.length;i++){
            int val = min + i*cd;
            if(set.contains(val)==false){
                return false;
            }
        }
        return true;
    }
}