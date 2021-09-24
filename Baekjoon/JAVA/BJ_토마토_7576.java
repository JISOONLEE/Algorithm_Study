import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_토마토_7576 {
	static int W;
	static int H;
	static int[][] map;
	static Queue<Tomato> queue;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static class Tomato {
		int x, y;

		Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		queue = new LinkedList<Tomato>();
		for (int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for (int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());

				if (map[h][w] == 1) {
					queue.add(new Tomato(h, w));
				}
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		int result = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			Tomato t = queue.poll();

			for (int i = 0; i < dx.length; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];

				if (nx < 0 || nx >= H || ny < 0 || ny >= W)
					continue;

				if (map[nx][ny] == 0) {
					queue.add(new Tomato(nx, ny));
					map[nx][ny] = map[t.x][t.y] + 1;
				}
			}
		}
		
		for(int i=0;i<H;i++) {
			for(int j = 0;j<W;j++) {
				if(map[i][j] == 0)
					return -1;
				result = Math.max(result, map[i][j]);
			}
		}
		if(result == 1) return 0;
		else return result -1;
	}
}
