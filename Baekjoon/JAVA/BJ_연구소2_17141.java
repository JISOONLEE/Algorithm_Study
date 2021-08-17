import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_연구소2_17141 {
	public static int N;
	public static int M;
	public static int result = Integer.MAX_VALUE;
	public static int[][] map;
	public static int[][] virusMap;
	public static LinkedList<Point> virusList = new LinkedList<>();
	public static int[] pt;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusList.add(new Point(i, j, 0));
					map[i][j] = 0;
				}
			}
		}
		pt = new int[M];
		comb(0, 0);
		
		if (result == Integer.MAX_VALUE)
			System.out.println(-1);
		else {
			System.out.println(result);
		}
	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			virusSpread(pt);
			return;
		}
		for (int i = start; i < virusList.size(); i++) {
			pt[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static void virusSpread(int[] virus) {
		Queue<Point> queue = new LinkedList<>();

		virusMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					virusMap[i][j] = 0;
				} else {
					virusMap[i][j] = map[i][j];
				}
			}
		}

		for (int i = 0; i < virus.length; i++) {
			queue.add(virusList.get(virus[i]));
			virusMap[virusList.get(virus[i]).x][virusList.get(virus[i]).y] = -1;
		}

		while (!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			int time = queue.peek().time;
			queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (virusMap[nx][ny] == 0) {
						virusMap[nx][ny] = time + 1;
						queue.add(new Point(nx, ny, time + 1));

					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		boolean check = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (virusMap[i][j] == 0) {
					check = true;
				}
				max = Math.max(max, virusMap[i][j]);
			}
		}
		
		if (!check)
			result = Math.min(max, result);
	}

	private static class Point {
		int x;
		int y;
		int time;

		Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
