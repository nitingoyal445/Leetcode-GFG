class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && visited[i][j] == false){
                    getAllConnectedComponent(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void getAllConnectedComponent(char[][] grid, int i, int j, boolean[][] visited){
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0' || visited[i][j]==true){
            return;
        }
        visited[i][j]=true;
        getAllConnectedComponent(grid, i-1, j, visited);
        getAllConnectedComponent(grid, i, j+1, visited);
        getAllConnectedComponent(grid, i, j-1, visited);
        getAllConnectedComponent(grid, i+1, j, visited);
        
    }
}