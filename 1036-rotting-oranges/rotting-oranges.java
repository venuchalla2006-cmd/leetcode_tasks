class Solution {
    class Pair{
        int row,col,time;

        Pair(int r, int c, int t){
            row = r;
            col = c;
            time = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        //1.add all rotten oranges to queue , also keep a track of fresh oranges
        int freshCnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                }
                if(grid[i][j] == 1){
                    freshCnt++;
                }
            }
        }

        //2. the adj 4 directions , where we can move
        int dRow[] = {-1,1,0,0};
        int dCol[] = {0,0,-1,1};

        //3.4-directional bfs on the ele of queue , also keeping RottenCnt and Maxtime

        int rc =0,maxTime =0;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int time = curr.time;
            //we need to update the maxTime
            maxTime = Math.max(maxTime,time);

            //traverse in all 4 directions
            for(int k=0;k<4;k++){
                int newR = row+dRow[k];
                int newC = col+dCol[k];

                //check if are we within the bounds
                if(newR >=0 && newR < n && newC >= 0 && newC < m && grid[newR]
                [newC] == 1){
                    //if 1 we can rot it so add to queue
                    //rot the orange
                    grid[newR][newC] = 2;
                    q.add(new Pair(newR,newC,time+1));
                    rc++; //increment the rottenCnt
                }
            }
        }

        // 4.return the ans 
        return rc == freshCnt ? maxTime:-1;
        //we can say if rc == freshcnt all oranges have been rottenn out , else some are remaining.

    }
}