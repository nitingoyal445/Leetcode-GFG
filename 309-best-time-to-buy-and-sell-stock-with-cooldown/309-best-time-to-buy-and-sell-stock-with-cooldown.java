class Solution {
    public int maxProfit(int[] price) {
        int bsp = -price[0];
        int ssp = 0;
        int csp = 0;
        
        for(int i=1;i<price.length;i++){
            int bsp_n = Math.max(bsp, csp-price[i]);
            int ssp_n = Math.max(ssp, price[i]+bsp);
            int csp_n = Math.max(csp, ssp);
            
            bsp = bsp_n;
            ssp = ssp_n;
            csp = csp_n;
        }
        return ssp;
    }
}