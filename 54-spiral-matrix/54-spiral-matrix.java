class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowLeft = 0;
        int rowRight = matrix.length-1;
        int colRight = matrix[0].length-1;
        int colLeft = 0;
        List<Integer> list = new ArrayList<>();
        
        while((rowLeft<=rowRight) && (colRight>=colLeft)){
            
            for(int i=colLeft;i<=colRight;i++){
                list.add(matrix[rowLeft][i]); 
                System.out.print(matrix[rowLeft][i]+" ");
            }
            rowLeft++;
            System.out.println();
        
            for(int i=rowLeft;i<=rowRight;i++){
                list.add(matrix[i][colRight]);
                System.out.print(matrix[i][colRight]+" ");
            }
            colRight--;
            System.out.println();
            if(rowLeft<=rowRight){
                for(int i=colRight;i>=colLeft;i--){
                list.add(matrix[rowRight][i]); 
                System.out.print(matrix[rowRight][i]+" ");
            }
            rowRight--;
            }
            
            System.out.println();
            if(colLeft<=colRight){
                for(int i=rowRight;i>=rowLeft;i--){
                    list.add(matrix[i][colLeft]); 
                    System.out.print(matrix[i][colLeft]+" ");
                }
                colLeft++;
            }
            
            System.out.println();
            System.out.println(rowLeft+" "+colRight+" "+rowRight+" "+colLeft);
        }
        return list;
    }
}