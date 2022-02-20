class Solution {
    public int countEven(int num) {
        int count=0;
        for(int i=1;i<=num;i++){
            if(evenSumOrNot(i)){
                count++;
            }
        }
        return count;
    }
    
    private boolean evenSumOrNot(int number){
        int sum = 0;
        while(number > 0)  
        {  
            int digit = number % 10;  
            sum = sum + digit;  
            number = number / 10;  
        }
        if(sum%2==0){
            return true;
        }
        return false;
    }
}