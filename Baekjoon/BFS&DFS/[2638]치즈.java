import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2638_치즈 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<Point> cheeseList;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static class Point {
        int x,y;
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
        map = new int[N][M];
        cheeseList = new ArrayList<>();

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseList.add(new Point(i, j));
                }
            }
        }

        int time = 0;
        while (true) {
            outsideAir();
            meltCheese();
            time++;
            if (cheeseList.size() == 0)
                break;
        }

        System.out.println(time);
    }

    private static void outsideAir() {
        visited = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        visited[0][0] = true;
        map[0][0] = 9;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i=0;i<4;i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

                if (map[nx][ny] != 1) {
                    map[nx][ny] = 9;
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    private static void meltCheese() {
        ArrayList<Integer> meltCheeseList = new ArrayList<>();

        for (int i=cheeseList.size()-1;i>=0;i--) {
            Point p = cheeseList.get(i);
            int cnt = 0;

            for (int j=0;j<4;j++) {
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == 9) cnt++;
            }

            if (cnt >= 2) {
                meltCheeseList.add(i);
            }
        }

        for (int i : meltCheeseList) {
            Point p = cheeseList.get(i);
            map[p.x][p.y] = 9;
            cheeseList.remove(i);
        }
    }
}
