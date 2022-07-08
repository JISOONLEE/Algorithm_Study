import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16928_뱀과사다리게임 {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static boolean[] visited = new boolean[101];
    static int[] count = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0;i<N+M;i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bfs();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if(current == 100) {
                System.out.println(count[current]);
                return;
            }

            for(int i=1;i<=6;i++) {
                int next = current + i;
                if(100 < next || visited[next]) continue;
                visited[next] = true;

                if (map.containsKey(next)) {
                    if (visited[map.get(next)]) continue;
                    next = map.get(next);
                    visited[next] = true;
                }
                queue.offer(next);
                count[next] = count[current]+1;
            }
        }
    }
}
