import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_17780_새로운게임 {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] map;
    private static ArrayList<Integer>[][] horse;
    private static HashMap<Integer, Point> hm;
    private static int N, K;

    private static class Point {
        int x, y, dir;
        Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        horse = new ArrayList[N+1][N+1];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                horse[i][j] = new ArrayList<Integer>();
            }
        }

        hm = new HashMap<>();
        for (int i=1;i<=K;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;

            horse[x][y].add(i);
            hm.put(i, new Point(x, y, dir));
        }

        int time = 1;
        outer : while(true) {
            if (time > 1000) {
                System.out.println(-1);
                break;
            }

            for (int i=1;i<=K;i++) {
                Point p = hm.get(i);

                int nx = p.x + dx[p.dir];
                int ny = p.y + dy[p.dir];
                int idx = horse[p.x][p.y].indexOf(i);
                if (idx != 0) continue;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 2) {
                    if (p.dir%2 == 0) {
                        p.dir += 1;
                    } else {
                        p.dir -= 1;
                    }
                    int newX = p.x + dx[p.dir];
                    int newY = p.y + dy[p.dir];

                    if (newX < 0 || newX >= N || newY < 0 || newY >= N || map[newX][newY] == 2) continue;
                    hm.put(i, new Point(p.x, p.y, p.dir));
                    i--;

                } else if (map[nx][ny] == 0) {
                    int len = horse[p.x][p.y].size();
                    for (int j=0;j<len;j++) {
                        int k = horse[p.x][p.y].remove(0);
                        Point tmp = hm.get(k);
                        horse[nx][ny].add(k);
                        hm.put(k, new Point(nx, ny, tmp.dir));
                    }
                    if (horse[nx][ny].size()>=4){
                        System.out.println(time);
                        break outer;
                    }
                } else if (map[nx][ny] == 1) {
                    for (int j=horse[p.x][p.y].size()-1;j>=0;j--) {
                        int k = horse[p.x][p.y].remove(j);
                        Point tmp = hm.get(k);
                        horse[nx][ny].add(k);
                        hm.put(k, new Point(nx, ny, tmp.dir));
                    }
                    if (horse[nx][ny].size()>=4){
                        System.out.println(time);
                        break outer;
                    }
                }
            }
            time++;
        }
    }
}
