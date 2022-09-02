package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21610_마법사상어와비바라기 {
    private static int N, M;
    private static int[][] A;
    private static boolean[][] visited;

    private static Queue<Point> queue;
    private static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue = new LinkedList<>();
        queue.add(new Point(N-1, 0));
        queue.add(new Point(N-1, 1));
        queue.add(new Point(N-2, 0));
        queue.add(new Point(N-2, 1));

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            move(d, s);
        }

        int answer = 0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                answer += A[i][j];
            }
        }
        System.out.println(answer);
    }

    private static void move(int d, int s) {
        visited = new boolean[N][N];
        for (Point p : queue) {
            p.x = (N + p.x + dx[d]*(s%N))%N;
            p.y = (N + p.y + dy[d]*(s%N))%N;

            A[p.x][p.y]++;
        }

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            visited[p.x][p.y] = true;

            int cnt = 0;
            for (int i=1;i<8;i+=2) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (A[nx][ny] > 0) A[p.x][p.y]++;
            }
        }

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (!visited[i][j] && A[i][j] >= 2) {
                    queue.add(new Point(i, j));
                    A[i][j] -= 2;
                }
            }
        }
    }
}
