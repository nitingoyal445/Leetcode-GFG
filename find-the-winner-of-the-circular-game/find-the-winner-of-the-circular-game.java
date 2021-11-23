class Solution {
    
    public int solution(int n, int k){
        if(n==0) return 1;
        
        int x = solution(n-1, k);
        int y = (x+k)%n;
        
        return y;
    }
    
    public int findTheWinner(int n, int k) {
        return solution(n,k)+1;
    }
}