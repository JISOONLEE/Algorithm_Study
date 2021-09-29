import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_달이차오른다가자_1194 {
	static int N;
	static int M;
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][][] visit;
	static int result = Integer.MAX_VALUE;

	private static class Point {
		int x, y;
		int cnt;
		int key;

		Point() {}

		Point(int x, int y, int cnt, int key) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new char[N][M];
		visit = new boolean[N][M][64]; // 2^6 모든 경우의 수를 다 가지고 가야함.
		Point start = new Point();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					start = new Point(i, j, 0, 0);
				}
			}
		}

		bfs(start);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static void bfs(Point pt) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(pt);
		map[pt.x][pt.y] = '.';

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				
				if(visit[nx][ny][p.key]) continue;
				if (map[nx][ny] == '1')
					result = Math.min(result, p.cnt + 1);

				if (map[nx][ny] == '.') {
					queue.add(new Point(nx, ny, p.cnt + 1, p.key));
					visit[nx][ny][p.key] = true;
				} 
				else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
					int key = p.key | (1 << map[nx][ny] - 'a'); // or 연산을 통해서 존재하는 키를 모을 수 있도록.
					queue.add(new Point(nx, ny, p.cnt + 1, key));
					visit[nx][ny][key] = true;
				} 
				else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
					int check = p.key & (1 << map[nx][ny] - 'A'); // 만약 0보다 크다면 키를 가지고 있다는 것.
					if (check > 0) {
						queue.add(new Point(nx, ny, p.cnt + 1, p.key));
						visit[nx][ny][p.key] = true;
					}
				}
			}
		}
	}
}
