class Cell {
    int row;
    int col;
    Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
    
}

class Solution {
    
    public void bfs(int r, int c, int[][] vis, char[][] grid){
        vis[r][c] = 1;
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(r, c));
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            for(int delRow = -1; delRow<=1; delRow++){
                for(int delCol = -1; delCol<=1; delCol++){
                    if(Math.abs(delRow) == 1 && Math.abs(delCol) == 1){
                        continue;
                    } else {
                      int newRow = row+delRow;
                    int newCol = col+delCol;
                    if(newRow>=0 && newCol>=0 && newRow<grid.length 
                       && newCol<grid[0].length && vis[newRow][newCol] == 0
                      && grid[newRow][newCol] == '1'){
                        vis[newRow][newCol] = 1;
                        q.add(new Cell(newRow, newCol));
                    }  
                    }
                    
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int[][] vis = new int[R][C];
        int count = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(vis[r][c] == 0 && grid[r][c] == '1'){
                    count++;
                    bfs(r, c, vis, grid);
                }
            }
        }
        return count;
        
    }
}