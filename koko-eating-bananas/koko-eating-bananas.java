class Solution {
    
    private boolean isPossible(int[] piles,int h,int speed){
        int time = 0;
        for(int i=0;i<piles.length;i++){
            time+=(int)Math.ceil(piles[i]*1.0 / speed);
        }
        return time<=h;
    }
    public int minEatingSpeed(int[]piles,int h) {
        //write your code here
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max, piles[i]);
        }
        int lo = 1;
        int hi = max;
        int k = Integer.MAX_VALUE;
        
        while(lo<=hi){
            int speed = lo+(hi-lo)/2;
            
            if(isPossible(piles, h, speed) == true){
                k = speed;
                hi = speed-1;
            }else{
                lo = speed+1;
            }
        }
        return k;
    }
    
}