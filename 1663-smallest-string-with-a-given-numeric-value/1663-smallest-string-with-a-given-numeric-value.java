class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder str = new StringBuilder("");
        for(int i=0;i<n;i++){
            str = str.append("a");
            k--;
        }
        int j = n-1;
        while(k>=25){
            str.setCharAt(j, (char)('a'+25));
            j--;
            k-=25;
        }
        if(k>0){
            str.setCharAt(j, (char)('a'+k));
        }
        return str.toString();
    }
}