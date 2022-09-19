import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int N = board.length, answer = Integer.MAX_VALUE;
        int[][][] cost = new int[N][N][4];
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0, 1});
        queue.add(new int[] {0, 0, 0, 2});
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for(int i=0;i<4;i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                int nc = curr[2] + (curr[3] == i ? 100 : 600);
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1 || cost[nx][ny][i] <= nc) continue;
                cost[nx][ny][i] = nc;
                queue.add(new int[]{nx, ny, nc, i});
            }
        }
        
        for(int i=0;i<4;i++) {
            answer = Math.min(answer, cost[N-1][N-1][i]);
        }
        
        return answer;
    }
}
