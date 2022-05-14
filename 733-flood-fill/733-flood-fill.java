class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int color = image[sr][sc];
        modifyImage(image, sr, sc, newColor, visited, color);
        return image;
    }
    
    public void modifyImage(int[][] image, int i, int j, int newColor, boolean[][] visited, int color){
        if(i<0 || j<0 || i>=image.length || j>=image[0].length || image[i][j]!=color || visited[i][j]==true){
            return;
        }
        visited[i][j] = true;
        image[i][j] = newColor;
        modifyImage(image, i-1, j, newColor, visited, color);
        modifyImage(image, i, j-1, newColor, visited, color);
        modifyImage(image, i+1, j, newColor, visited, color);
        modifyImage(image, i, j+1, newColor, visited, color);
        visited[i][j] = false;
    }
}