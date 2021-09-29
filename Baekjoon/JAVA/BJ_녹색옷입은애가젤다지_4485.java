import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_녹색옷입은애가젤다지_4485 {
	static int N;
	static int[][] map;
	static int[][] wgt;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static class Point implements Comparable<Point> {
		int x, y;
		int weight;

		Point(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while ((N = Integer.parseInt(br.readLine()))!=0) {
			map = new int[N][N];
			wgt = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					wgt[i][j] = Integer.MAX_VALUE;
				}
			}
			System.out.println("Problem "+tc+": "+solve());
			tc++;
		}
	}

	private static int solve() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0, map[0][0]));
		wgt[0][0] = map[0][0];

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (map[nx][ny] + wgt[p.x][p.y] < wgt[nx][ny]) {
					wgt[nx][ny] = map[nx][ny] + wgt[p.x][p.y];
					queue.add(new Point(nx, ny, wgt[nx][ny]));
				}
			}
		}

		return wgt[N - 1][N - 1];
	}
}
