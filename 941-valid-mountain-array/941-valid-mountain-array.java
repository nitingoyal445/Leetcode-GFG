class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3){
            return false;
        }
        boolean flag = false;
        if(arr[1]<arr[0]){
            return false;
        }
        int i = 1;
        while(i<arr.length){
            if(arr[i]>arr[i-1]){
                i++;
            }else{
                flag = true;
                break;
            }
        }
        if(i == arr.length){
            return false;
        }
        while(i<arr.length){
            if(arr[i-1]>arr[i]){
                flag = false;
                i++;
            }else{
                return false;
            }
        }
        if(flag){
            return false;
        }
        return true;
    }
}