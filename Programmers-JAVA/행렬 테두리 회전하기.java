import java.util.*;
import java.lang.*;

class Solution {
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    private int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        int num = 1;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                map[i][j] = num++;
            }
        }
        for(int i=0;i<queries.length;i++) {
            int px = queries[i][0]-1;
            int py = queries[i][1]-1;
            int fx = queries[i][2]-1;
            int fy = queries[i][3]-1;
            int dir = 0;
            int nMin = map[px][py];
            int temp = map[px][py];
            int nx = px;
            int ny = py;
            while(true) {
                nx += dx[dir];
                ny += dy[dir];

                if(nx>=px && ny>=py && nx<=fx && ny<=fy) {
                    int temp2 = map[nx][ny];
                    map[nx][ny] = temp;
                    temp = temp2;
                    nMin = Math.min(nMin, map[nx][ny]);
                } else {
                    nx-=dx[dir];
                    ny-=dy[dir];
                    if(dir == 3)
                        break;
                    dir++;
                }
            }
            answer[i] = nMin;
        }
        return answer;
    }
}

class Node {
    int x1, y1;
    int x2, y2;
    Node(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
