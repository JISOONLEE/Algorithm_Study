import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1238_파티 {
    static int N,M, X;
    static List<Node>[] list, reverseList;

    static class Node implements Comparable<Node>{
        int idx, dist;
        Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        reverseList = new ArrayList[N+1];

        for (int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
            reverseList[v].add(new Node(u, w));
        }

        int[] back = dijkstra(list);
        int[] go = dijkstra(reverseList);

        int max = 0;

        for (int i=1;i<=N;i++) {
            max = Math.max(max, go[i] + back[i]);
        }

        System.out.println(max);
    }

    public static int[] dijkstra(List<Node>[] list) {
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        int dist[] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        while(!pq.isEmpty()) {
            int idx = pq.poll().idx;
            if (visited[idx]) continue;
            visited[idx] = true;

            for (Node node : list[idx]) {
                if (dist[node.idx] > dist[idx] + node.dist){
                    dist[node.idx] = dist[idx] + node.dist;
                    pq.add(new Node(node.idx, dist[node.idx]));
                }
            }
        }

        return dist;
    }
}
