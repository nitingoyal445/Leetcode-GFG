public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int reverse = 0;
        int j= 0;
        for(int i=31;i>=0;i--){
            int mask = (1<<i);
            if((mask&n)!=0){  // bit is ON
                int mask2 = (1<<j);
                reverse = reverse|mask2;
            }
            j++;
        }
        return reverse;
    }
}