class Solution {
    private void swap(char[] arr,int i,int indx){
        char temp = arr[i];
        arr[i] = arr[indx];
        arr[indx] = temp;
    }
    
    public int maximumSwap(int n) {
        //convert number into string
        String num=""+n;
        //convert number into string
        char[] arr = num.toCharArray();
        
        int[] lastIndxOfDigit = new int[10];
        //travel and fill last index of digits
        for(int i=0;i<arr.length;i++){
            lastIndxOfDigit[arr[i] - '0'] = i;
        }
        //travel and find swapping point
        for(int i=0;i<arr.length;i++){
            int digit = arr[i] - '0';
            int indx  = i;
            for(int j=9;j>digit;j--){
                if(lastIndxOfDigit[j] > i){
                    indx = lastIndxOfDigit[j];
                    break;
                }
            }
            if(indx != i){
            swap(arr, i, indx);
            break;
        }
        }
        String res = String.valueOf(arr);
        
        return Integer.parseInt(res);
    }
}