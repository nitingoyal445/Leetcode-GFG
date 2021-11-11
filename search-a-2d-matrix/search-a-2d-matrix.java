class Solution {
    private static int findRowIndx(int[][] matrix, int target){
        int indx = -1;
        int lo=0;
        int hi = matrix.length - 1;
        
        while(lo <= hi){
            int midRow = lo + (hi-lo)/2;
            if(matrix[midRow][0]<= target && target <= matrix[midRow][matrix[0].length-1]){
                indx = midRow;
                break;
            }else if(target < matrix[midRow][0]){
                hi = midRow-1;
            }else{
                lo = midRow+1;
            }
        }
        return indx;
    }
    
    private static int findInIthRow(int[][] matrix, int target,int row){
        int indx = -1;
        int lo = 0;
        int hi = matrix[0].length - 1;
        
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            
            if(matrix[row][mid] == target){
                indx = mid;
                break;
            }else if(matrix[row][mid] < target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
            
        }
        return indx;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndx = findRowIndx(matrix, target);
        if(rowIndx == -1) return false;
        int colIndx = findInIthRow(matrix, target, rowIndx);
        return colIndx != -1;
    }
}