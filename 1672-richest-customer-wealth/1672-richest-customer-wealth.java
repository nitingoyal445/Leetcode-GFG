class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth=Integer.MIN_VALUE;
        for(int[] customer: accounts){
            int sum = 0;
            for(int bank : customer){
                sum +=bank;
            }
            maxWealth = Math.max(sum, maxWealth);
        }
        return maxWealth;
    }
}