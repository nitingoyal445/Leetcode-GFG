class Solution {
    
    class Pair implements Comparable<Pair>{
        int l;
        int r;
        Pair(int l, int r){
            this.l = l;
            this.r = r;
        }
        public int compareTo(Pair o){
            return this.r-o.r;
        }
        
    }
    public int findLongestChain(int[][] pairs) {
        
        Pair[] arr = new Pair[pairs.length];
        
        for(int i=0;i<pairs.length;i++){
            arr[i]=new Pair(pairs[i][0], pairs[i][1]);
        }
        Arrays.sort(arr);
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = 1;
        int ans = 1;
        for(int i=0;i<arr.length;i++){
            max = 0;
            for(int j=i-1;j>=0;j--){
                if(arr[j].r<arr[i].l){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}