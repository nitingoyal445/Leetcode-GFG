class Solution {
    public int maxProfit(int[] prices) {
        
        int[] buy = new int[prices.length];
        int min = prices[0];
        for(int i=0;i<prices.length;i++){
            min = Math.min(prices[i], min);
            buy[i] = min;
        }
        int[] sell = new int[prices.length];
        int max = prices[prices.length-1];
        for(int i=prices.length-1; i>=0; i--){
            max = Math.max(prices[i], max);
            sell[i] = max;
        }
        int max_profit = Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++){
            int profit = sell[i] - buy[i];
            if(profit>max_profit){
                max_profit = profit;
            }
        }
        return max_profit;
    }
}