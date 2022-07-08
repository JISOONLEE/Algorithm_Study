import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569_토마토 {
    static int N, M, H;
    static int[][][] map;
    static Queue<Tomato> queue;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static class Tomato {
        int x, y, z;
        Tomato(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        queue = new LinkedList<>();

        for (int i=0;i<H;i++) {
            for (int j=0;j<N;j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0;k<M;k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        queue.offer(new Tomato(i, j, k));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while(!queue.isEmpty()) {
            Tomato t = queue.poll();

            for (int i=0;i<6;i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                int nz = t.z + dz[i];

                if (nx<0 || nx>=N || ny<0 || ny>=M || nz<0 || nz>=H) continue;
                if (map[nz][nx][ny] == 0) {
                    queue.offer(new Tomato(nz, nx, ny));
                    map[nz][nx][ny] = map[t.z][t.x][t.y] + 1;
                }
            }
        }

        boolean check = false;
        int max = 0;
        outer : for (int i=0;i<H;i++) {
            for (int j=0;j<N;j++){
                for (int k=0;k<M;k++) {
                    if (map[i][j][k] == 0) {
                        check = true;
                        break outer;
                    }
                    if(max < map[i][j][k])
                        max = map[i][j][k];
                }
            }
        }

        if (check)
            return -1;
        else
            return max-1;
    }
}
