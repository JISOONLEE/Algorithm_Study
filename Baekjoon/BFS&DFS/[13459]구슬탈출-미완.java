import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13459_구술탈출 {
    private static int N, M;
    private static char[][] map;
    private static Point red, blue, out;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static class Point{
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static class Info {
        int rx, ry, bx, by;
        Info (int rx, int ry, int bx, int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'R') {
                    red = new Point(i, j, 0);
                    map[i][j] = '.';
                } else if(map[i][j] == 'B') {
                    blue = new Point(i, j, 0);
                    map[i][j] = '.';
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(red.x, red.y, blue.x, blue.y));
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[red.x][red.y][blue.x][blue.y] = true;

        int cnt = 1;
        while(!queue.isEmpty()) {

            for(int i=0;i<queue.size();i++) {
                Info info = queue.poll();

                for (int j = 0; j < 4; j++) {
                    Point nRed = move(info.rx, info.ry, j);
                    Point nBlue = move(info.bx, info.by, j);

                    if(map[nBlue.x][nBlue.y] == 'O') continue;
                    if(map[nRed.x][nRed.y] == 'O') return 1;

                    if(nRed.x == nBlue.x && nRed.y == nBlue.y) {
                        if(nRed.dist > nBlue.dist) {
                            nRed.x -= dx[j];
                            nRed.y -= dy[j];
                        } else {
                            nBlue.x -= dx[j];
                            nBlue.y -= dy[j];
                        }
                    }
                    if(visited[nRed.x][nRed.y][nBlue.x][nBlue.y]) continue;
                    visited[nRed.x][nRed.y][nBlue.x][nBlue.y] = true;
                    queue.add(new Info(nRed.x, nRed.y, nBlue.x, nBlue.y));
                }
            }
            if(++cnt > 10) return 0;
        }

        return 0;
    }

    private static Point move(int x, int y, int dir) {
        int dist = 0;
        while(map[x+dx[dir]][y+dy[dir]] != '#' && map[x][y] !='O') {
            x += dx[dir];
            y += dy[dir];
            dist++;
        }
        return new Point(x, y, dist);
    }
}
