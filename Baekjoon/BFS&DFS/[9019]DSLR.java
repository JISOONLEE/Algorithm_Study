import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9019_DSLR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc=0;tc<T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] register = new String[10000];

            queue.offer(a);
            visited[a] = true;
            Arrays.fill(register, "");

            while(!queue.isEmpty()) {
                int current = queue.poll();

                if (current == b) {
                    sb.append(register[b]+"\n");
                    break;
                }

                int D = (2 * current) % 10000;
                int S = current == 0 ? 9999 : current - 1;
                int L = (current % 1000) * 10 + current / 1000;
                int R = (current % 10) * 1000 + current / 10;

                if (!visited[D]) {
                    queue.add(D);
                    visited[D] = true;
                    register[D] = register[current] + "D";
                }

                if (!visited[S]) {
                    queue.add(S);
                    visited[S] = true;
                    register[S] = register[current] + "S";
                }

                if (!visited[L]) {
                    queue.add(L);
                    visited[L] = true;
                    register[L] = register[current] + "L";
                }

                if (!visited[R]) {
                    queue.add(R);
                    visited[R] = true;
                    register[R] = register[current] + "R";
                }
            }
        }
        System.out.println(sb.toString());
    }
}
