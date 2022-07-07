import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
dfs 통해 임의의 정점에서 가장 먼 정점 구하고 구한 정점으로부터 가장 먼 정점까지의 거리 구한다.
 */
public class BJ_1167_트리의지름 {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max;
    static int max_node;
    static class Node {
        int data, weight;
        Node(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for (int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st = null;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int node2 = Integer.parseInt(st.nextToken());
                if (node2 == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                list[node].add(new Node(node2, weight));
            }
        }

        visited = new boolean[N+1];
        dfs(1, 0);

        visited = new boolean[N+1];
        dfs(max_node, 0);

        System.out.println(max);
    }

    public static void dfs(int node, int len) {
        if (len > max) {
            max = len;
            max_node = node;
        }
        visited[node] = true;

        for (Node n : list[node]) {
            if (!visited[n.data]) {

                dfs(n.data, len + n.weight);
            }
        }
    }
}
