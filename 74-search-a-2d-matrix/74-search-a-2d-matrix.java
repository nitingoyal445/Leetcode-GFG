class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int findRow = -1;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]<= target && matrix[i][matrix[0].length-1]>=target){
                findRow = i;
                break;
            }
        }
        System.out.println(findRow);
        if(findRow>=0){
            return binarySearch(matrix, target, findRow);
        }
        return false;
    }
    
    public boolean binarySearch(int[][] matrix, int target, int i){
        int lo = 0;
        int hi = matrix[0].length-1;
        while(lo <= hi){
            int mid = lo+ (hi-lo)/2;
            if(matrix[i][mid] == target || matrix[i][lo] == target || matrix[i][hi] == target){
                return true;
            }
            else if(matrix[i][mid]<target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return false;
    }
}