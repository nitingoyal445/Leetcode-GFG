class Solution {
    public int maxProfit(int[] prices) {
        
        int[] buy = new int[prices.length];
        int min = prices[0];
        for(int i=0;i<buy.length;i++){
            min = Math.min(prices[i],min);
            buy[i] = min;
        }
        int max = prices[prices.length-1];
        int[] sell = new int[prices.length];
        
        for(int i=prices.length-1;i>=0; i--){
            max = Math.max(prices[i],max);
            sell[i] = max;
        }
        int maxProfit = Integer.MIN_VALUE;
        
        for(int i=0;i<buy.length;i++){
            int profit = sell[i]-buy[i];
            if(profit>maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}