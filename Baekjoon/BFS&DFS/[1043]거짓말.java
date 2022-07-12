import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1043_거짓말 {
    static ArrayList<Integer> truth = new ArrayList<>();
    static ArrayList<Integer>[] party;
    private static int N, M, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for (int i=0;i<num;i++) {
            truth.add(Integer.parseInt(st.nextToken()));
        }

        party = new ArrayList[M];
        for (int i=0;i<M;i++) {
            party[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int num2 = Integer.parseInt(st.nextToken());
            for (int j=0;j<num2;j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        count = M;
        bfs();
        System.out.println(count);
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        boolean[] partyVisited = new boolean[M];
        for (int i=0;i<truth.size();i++) {
            queue.offer(truth.get(i));
            visited[truth.get(i)] = true;
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (int i=0;i<M;i++) {
                if (!partyVisited[i] && party[i].contains(current)) {
                    for (int j=0;j<party[i].size();j++) {
                        int next = party[i].get(j);
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                    count--;
                    partyVisited[i] = true;
                }
            }
            System.out.println(Arrays.toString(partyVisited));
        }
    }
}
