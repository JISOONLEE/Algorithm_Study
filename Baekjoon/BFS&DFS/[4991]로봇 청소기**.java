import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_4991_로봇청소기 {
    private static int N, M, answer;
    private static char[][] map;
    private static int[][] dist;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[] order;
    private static boolean[] check;
    private static Point robot;
    private static ArrayList<Point> dirty;
    private static class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        while(true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (M == 0 && N == 0) break;

            map = new char[N][M];
            dirty = new ArrayList<>();
            for (int i=0;i<N;i++) {
                String str = br.readLine();
                for (int j=0;j<M;j++) {
                    map[i][j] = str.charAt(j);

                    if (map[i][j] == 'o') {
                        robot = new Point(i, j, 0);
                    } else if (map[i][j] == '*') {
                        dirty.add(new Point(i, j, 0));
                    }
                }
            }

            dirty.add(0, robot);

            dist = new int[dirty.size()][dirty.size()];
            for (int i=0;i<dirty.size();i++) {
                for (int j=0;j<dirty.size();j++) {
                    if (i != j)
                        dist[i][j] = bfs(i, j);
                }
            }

            order = new int[dirty.size()];
            check = new boolean[dirty.size()];
            answer = Integer.MAX_VALUE;
            dfs(1, 1);
            System.out.println(answer == Integer.MAX_VALUE ? -1 :answer);
        }
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == dirty.size()) {
            int dis = 0;
            int ori = 0;

            for (int i=1;i<order.length;i++) {
                int distance = dist[ori][order[i]];
                if (distance == -1) return;
                dis += distance;
                ori = order[i];
            }
            answer = Math.min(answer, dis);
            return;
        }
        for (int i=1;i<dirty.size();i++) {
            if (check[i]) continue;
            check[i] = true;
            order[idx] = i;
            dfs(idx+1, cnt+1);
            check[i] = false;
        }
    }

    private static int bfs(int to, int from) {
        Point a = dirty.get(to);
        Point b = dirty.get(from);
        boolean[][] visited = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();
        queue.add(a);
        visited[a.x][a.y] = true;
        
        while (!queue.isEmpty()) {
            for (int i=0;i<queue.size();i++) {
                Point p = queue.poll();

                if (p.x == b.x && p.y == b.y){
                    return p.dist;
                }

                for (int j=0;j<4;j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 'x') continue;
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, p.dist+1));
                }
            }
        }
        return -1;
    }
}
