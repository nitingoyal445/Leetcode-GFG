class Solution {
    public int countPrimes(int n) {
        if(n<=2)
            return 0;
        boolean[] track=new boolean[n];
        for(int i=2;i<=Math.sqrt(n);i++){
            if(track[i]==false){
                for(int j=i*i;j<n;j+=i){
                    track[j]=true;
                }
            }
        }
        int count=0;
        for(int m=2;m<n;m++){
            if(track[m]==false)
                count++;
        }
        return count;
}
}