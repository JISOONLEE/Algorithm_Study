import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6087_레이저통신 {
    private static int H, W;
    private static char[][] map;
    private static Point start, end;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int answer = Integer.MAX_VALUE;
    private static class Point {
        int x, y, dir, mirror;
        Point(int x, int y, int dir, int mirror) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirror = mirror;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];

        for(int i=0;i<H;i++) {
            String str = br.readLine();
            for (int j=0;j<W;j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'C') {
                    if (start == null) start = new Point(i, j, -1, 0);
                    else end = new Point(i, j, -1, 0);
                }
            }
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        int[][] visited = new int[H][W];
        visited[start.x][start.y] = 1;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == end.x && p.y == end.y) {
                answer = Math.min(answer, p.mirror);
                continue;
            }

            for(int i=0;i<4;i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == '*') continue;

                int nm = p.mirror;
                if (p.dir != -1 && p.dir != i) {
                    nm+=1;
                }

                if (visited[nx][ny] == 0 || visited[nx][ny] >= nm) {
                    visited[nx][ny] = nm;
                    queue.add(new Point(nx, ny, i, nm));
                }
            }

        }
    }
}
