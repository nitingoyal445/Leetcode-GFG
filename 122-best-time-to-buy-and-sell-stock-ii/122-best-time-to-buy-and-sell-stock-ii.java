class Solution {
    public int maxProfit(int[] price) {
        int buyDay=0;
        int sellDay=0;
        int profit=0;
        for(int i=1;i<price.length;i++){
            
            if(price[i]>price[i-1]){
                sellDay++;
            }else{
                profit+= price[sellDay]-price[buyDay];
                buyDay = i;
                sellDay = i;
            }
        }
        // if peek is present in end of price array
        profit += price[sellDay]-price[buyDay];
        
        return profit;
    }
}