class Solution {
    public int minFlips(int a, int b, int c) {
        int res=0;
        
        while(a!=0 || b!=0 || c!=0){
            int t = a&1;
            int m = b&1;
            int n = c&1;
            
            if((t|m)!=n){
                if(n==0){
                    if(t==1){
                        res++;
                    }
                    if(m==1){
                        res++;
                    }
                }else{
                    res++;
                }
            }
            
            a= a>>1;
            b= b>>1;
            c= c>>1;
        }
        return res;
    }
}