package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_16954_움직이는미로탈출 {
    private static char[][] map;
    private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0, 0};
    private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[8][8];

        for (int i=0;i<8;i++) {
            String str = br.readLine();
            for (int j=0;j<8;j++) {
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs() ? 1 : 0);
    }

    private static boolean bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited;

        queue.add(new Point(7, 0));

        while(!queue.isEmpty()) {
            int size = queue.size();
            visited = new boolean[8][8];

            for (int i=0;i<size;i++) {
                Point p = queue.poll();
                if (map[p.x][p.y] == '#') continue;
                if (p.x == 0 && p.y == 7) return true;

                for (int j=0;j<9;j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
                    if (visited[nx][ny] || map[nx][ny] == '#') continue;

                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            for (int i=7;i>=0;i--) {
                for (int j=0;j<8;j++) {
                    if (map[i][j] == '#') {
                        map[i][j] = '.';

                        if (i!=7) {
                            map[i+1][j] = '#';
                        }
                    }
                }
            }
        }
        return false;
    }
}
