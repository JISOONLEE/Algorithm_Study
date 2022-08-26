package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503_로봇청소기 {
    private static int N, M, answer;
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer++;
        clean(r, c, d);
        System.out.println(answer);
    }

    private static void clean(int x, int y, int d) {
        map[x][y] = 2;

        for (int i=0;i<4;i++) {
            int nd = (d+3)%4;
            int nx = x + dx[nd];
            int ny = y + dy[nd];

            if (nx >= 0 && nx < N && ny >= 0 && ny<M) {
                if (map[nx][ny] == 0) {
                    answer++;
                    clean(nx, ny, nd);
                    return;
                }
            }
            d = nd;
        }

        int nx = x + dx[(d+2)%4];
        int ny = y + dy[(d+2)%4];

        if (nx >= 0 && nx < N && ny >= 0 && ny<M && map[nx][ny] != 1) {
            clean(nx, ny, d);
        }
    }
}
