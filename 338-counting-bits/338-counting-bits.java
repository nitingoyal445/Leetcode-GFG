class Solution {
    public int[] countBits(int n) {
        
        int[] arr = new int[n+1];
        for(int i=0;i<=n;i++){
            arr[i] = countOnes(i);
        }
        return arr;
    }
    
    private int countOnes(int val){
        int c = 0;
        while(val!=0){
            int mask = val & (-val);
            val = val-mask;
            c++;
        }
        return c;
    }
}