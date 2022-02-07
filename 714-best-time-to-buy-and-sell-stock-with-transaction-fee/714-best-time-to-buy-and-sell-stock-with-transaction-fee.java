class Solution {
    public int maxProfit(int[] price, int fee) {
        int pibt = -price[0];  // profit if buy today
        int pist = 0; // profit if sell today
        
        for(int i=1;i<price.length;i++){
            int pibt2 = Math.max(pibt, pist-price[i]);
            int pist2 = Math.max(pist, price[i]+pibt-fee);
            pibt=pibt2;
            pist=pist2;
        }
        return pist;
    }
}