import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_12851_숨바꼭질2 {
    private static int N, K, answer, cnt;
    private static boolean[] visited;
    private static class Info {
        int idx, time;
        Info(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        answer = Integer.MAX_VALUE;

        bfs();
        System.out.println(answer);
        System.out.println(cnt);
    }

    private static void bfs() {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            visited[info.idx] = true;

            if (info.idx == K) {
                if (answer > info.time) {
                    answer = info.time;
                    cnt = 1;
                } else if (answer == info.time) cnt++;
                continue;
            }

            int[] next = {info.idx-1, info.idx+1, info.idx*2};

            for (int i=0;i<3;i++) {
                if (next[i] >= 0 && next[i]<=100000 && !visited[next[i]]) {
                    queue.offer(new Info(next[i], info.time+1));
                }
            }
        }
    }
}
