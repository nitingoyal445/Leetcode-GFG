class Solution {
    public int pivotIndex(int[] arr) {
        int tSum =0;
        for(int i=0;i<arr.length;i++){
            tSum+=arr[i];
        }
        int lSum=0;
        for(int i=0;i<arr.length;i++){
            tSum-=arr[i];
            if(lSum == tSum){
                return i;
            }
            lSum+=arr[i];
        }
        return -1;
    }
}