package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_3190_뱀 {
    private static int N;
    private static int[][] map;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static HashMap<Integer, String> move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            map[x][y] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        move = new HashMap<>();
        for (int i = 0;i<L;i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            move.put(t, d);
        }

        solve();
    }

    private static void solve() {
        ArrayList<int[]> snake = new ArrayList<>();
        snake.add(new int[]{0, 0});

        int time = 0;
        int d = 0;
        int px = 0, py = 0;

        outer : while(true) {
            int nx = px + dx[d];
            int ny = py + dy[d];
            time++;

            if (nx < 0 || nx >= N || ny < 0 || ny >=N) break;
            for (int i=0;i<snake.size();i++) {
                if (snake.get(i)[0] == nx && snake.get(i)[1] == ny) break outer;
            }

            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snake.add(new int[]{nx, ny});
            } else {
                snake.add(new int[]{nx, ny});
                snake.remove(0);
            }

            px = nx;
            py = ny;

            if (move.containsKey(time)) {
                if (move.get(time).equals("D")) {
                    d++;
                    if (d == 4) d = 0;
                } else if (move.get(time).equals("L")) {
                    d--;
                    if (d == -1) d = 3;
                }
            }
        }
        System.out.println(time);
    }
}
