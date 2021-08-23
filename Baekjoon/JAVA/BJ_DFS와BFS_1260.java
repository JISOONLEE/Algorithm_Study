import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_DFS와BFS_1260 {
	static int N;
	static boolean[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		map = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			map[from][to] = true;
			map[to][from] = true;
		}

		visited = new boolean[N + 1];
		dfs(start);

		System.out.println();
		visited = new boolean[N + 1];
		bfs(start);
	}

	static void dfs(int start) {
		System.out.print(start + " ");
		visited[start] = true;
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && map[start][i])
				dfs(i);
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && map[current][i]) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}
