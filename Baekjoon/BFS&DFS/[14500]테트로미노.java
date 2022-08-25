package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500_테트로미노 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                dfs(i, j, 0, 0);

                int sum = 0;
                // 1. ㅜ
                if (i+1<N && j+2<M) {
                    sum = map[i][j]+ map[i][j+1]+map[i][j+2]+map[i+1][j+1];
                    answer = Math.max(answer, sum);
                }
                // 2. ㅗ
                if (i-1>=0 && j+2<M) {
                    sum = map[i][j]+ map[i][j+1]+map[i][j+2]+map[i-1][j+1];
                    answer = Math.max(answer, sum);
                }
                // 3. ㅓ
                if (i+2 < N && j-1>=0) {
                    sum = map[i][j] + map[i+1][j]+map[i+2][j]+map[i+1][j-1];
                    answer = Math.max(answer, sum);
                }
                // 4. ㅏ
                if (i+2 < N && j+1<M) {
                    sum = map[i][j] + map[i+1][j]+map[i+2][j]+map[i+1][j+1];
                    answer = Math.max(answer, sum);
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, cnt+1, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }
}
