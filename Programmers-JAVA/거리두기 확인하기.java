import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static class Node {
        int x;
        int y;
        int dis;
        Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    private boolean[][] check;
    private String[][] map;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        map = new String[5][5];
        check = new boolean[5][5];
        for(int i=0;i<places.length;i++) {
            for(int j=0;j<places[i].length;j++) {
                map[j] = places[i][j].split("");
                Arrays.fill(check[j], false);
            }

            boolean res = false;
            for(int r=0;r<5;r++) {
                for(int c=0;c<5;c++) {
                    if(map[r][c].equals("P")) {
                        if(!dfs(r, c)) {
                            res = true;
                        }
                    }
                }
            }
            if(res)
                answer[i] = 0;
            else
                answer[i] = 1;
        }
        return answer;
    }

    private boolean dfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        check[x][y] = true;
        boolean chk = false;
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.dis>=2)
                continue;
            for(int i=0;i<4;i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int ndis = current.dis;
                if(nx>=0 && ny>=0 && nx<5 && ny < 5) {
                    if(!check[nx][ny]) {
                        if(map[nx][ny].equals("O")) {
                            queue.add(new Node(nx, ny, ndis+1));
                        } else if(map[nx][ny].equals("P")) {
                            if(ndis<=2) {
                                chk = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(chk)
                return false;
        }
        for(int i=0; i<check.length; i++){
            Arrays.fill(check[i],false);
        }
        return true;
    }
}
