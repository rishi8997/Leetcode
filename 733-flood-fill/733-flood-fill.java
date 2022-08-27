// Approach: Define output matrix and copy input to the output matrix. Call DFS on start node. Fill start with color and go to all the unvisited valid neighbors of node and recursively call DFS.

class Solution {
    public void dfs(int row, int col, int[][] image, int[][] ans, int color){
        ans[row][col] = color;
        int iniColor = image[row][col];
        int r = image.length;
        int c = image[0].length;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        for(int i=0; i<4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow>=0 && nRow<r && nCol>=0 && nCol<c && image[nRow][nCol] == iniColor
              && ans[nRow][nCol] != color){
                dfs(nRow, nCol, image, ans, color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length;
        int c = image[0].length;
        int[][] ans = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                ans[i][j] = image[i][j];
            }
        }
        dfs(sr, sc, image, ans, color);
        return ans;
        
    }
}