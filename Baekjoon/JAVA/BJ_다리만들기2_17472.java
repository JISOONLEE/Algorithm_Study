import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_다리만들기2_17472 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] check;
	static int island = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Edge>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!check[i][j] && map[i][j] == 1) {
					island++;
					bfs(new Point(i, j));
				}
			}
		}

		list = new ArrayList[island + 1];
		for (int i = 1; i <= island; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					makeEdge(new Point(i, j));
				}
			}
		}

		System.out.println(prim());
	}

	private static int prim() {
		boolean[] visit = new boolean[island + 1];
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge(1, 0));

		int result = 0;
		int cnt = 0;

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();

			if (visit[edge.end])
				continue;
			result += edge.weight;
			visit[edge.end] = true;
			if (++cnt == island)
				return result;

			for (int i = 0; i < list[edge.end].size(); i++) {
				Edge n_edge = list[edge.end].get(i);
				if (!visit[n_edge.end])
					queue.add(n_edge);
			}
		}
		return -1;
	}

	private static void makeEdge(Point p) {
		int rx = p.x;
		int ry = p.y;
		int island_num = map[rx][ry];

		int cnt = 0;
		while (true) {
			ry += 1;
			if (ry >= M)
				break;
			if (map[rx][ry] == island_num) {
				cnt=0;
				continue;
			}
			else if (map[rx][ry] == 0) {
				cnt++;
				continue;
			} else {
				if (cnt > 1) {
					list[island_num].add(new Edge(map[rx][ry], cnt));
					list[map[rx][ry]].add(new Edge(island_num, cnt));
				}
				break;
			}
		}

		int bx = p.x;
		int by = p.y;

		cnt = 0;
		while (true) {
			bx += 1;
			if (bx >= N)
				break;
			if (map[bx][by] == island_num) {
				cnt=0;
				continue;
			}
			else if (map[bx][by] == 0) {
				cnt++;
				continue;
			} else {
				if (cnt > 1) {
					list[island_num].add(new Edge(map[bx][by], cnt));
					list[map[bx][by]].add(new Edge(island_num, cnt));
				}
				break;
			}
		}
	}

	private static void bfs(Point p) {
		Queue<Point> queue = new LinkedList<>();
		check[p.x][p.y] = true;
		map[p.x][p.y] = island;
		queue.add(p);

		while (!queue.isEmpty()) {
			Point pt = queue.poll();
			int qx = pt.x;
			int qy = pt.y;
			for (int i = 0; i < 4; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if (map[nx][ny] == 1 && !check[nx][ny]) {
					map[nx][ny] = island;
					check[nx][ny] = true;
					queue.add(new Point(nx, ny));
				}
			}
		}

	}

	private static class Edge implements Comparable<Edge> {
		int end;
		int weight;

		Edge(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}

	private static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
