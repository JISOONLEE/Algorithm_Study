import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13549_숨바꼭질3 {
    private static int N, K;
    private static int answer = Integer.MAX_VALUE;
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
        bfs();
        System.out.println(answer);
    }

    private static void bfs(){
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(N, 0));

        while(!queue.isEmpty()) {
            Info info = queue.poll();
            visited[info.idx] = true;

            if (info.idx == K)
                answer = Math.min(answer, info.time);

            if (info.idx * 2 <= 100000 && !visited[info.idx * 2]) {
                queue.add(new Info(info.idx * 2, info.time));
            }
            if (info.idx + 1 <= 100000 && !visited[info.idx + 1]) {
                queue.add(new Info(info.idx + 1, info.time + 1));
            }
            if (info.idx - 1 >= 0 && !visited[info.idx - 1]) {
                queue.add(new Info(info.idx - 1, info.time + 1));
            }
        }
    }
}
