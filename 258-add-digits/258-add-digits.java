class Solution {
    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        int sum=num;
        while(sum>=10){
            int n = sum;
            sum = 0;
            while(n!=0){
                int rem = n%10;
                sum+=rem;
                n/=10;
            }
        }
        return sum;
    }
}