import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_말이되고픈원숭이_1600 {
	static int K;
	static int W;
	static int H;
	static int[][] map;
	static boolean[][][] check;
	static int[] hx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] hy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		check = new boolean[H][W][K+1]; // K 별 방문 처리를 해줘야함
		for (int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for (int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Info> queue = new LinkedList<Info>();
		queue.add(new Info(0, 0, K, 0));
		check[0][0][K] = true;
		while (!queue.isEmpty()) {
			Info info = queue.poll();
//			System.out.println(info.x+", "+info.y +" / "+info.cnt + " / k: " +info.k);
			
			if(info.x == H-1 && info.y == W-1) {
				return info.cnt;
			}
			
			
			for (int i = 0; i < 4; i++) {
				int nx = info.x + dx[i];
				int ny = info.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= H || ny >= W)
					continue;
				if (check[nx][ny][info.k])
					continue;

				if (map[nx][ny] == 0) {
					check[nx][ny][info.k] = true;
					queue.add(new Info(nx, ny, info.k, info.cnt+1));
				}
			}

			if (info.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = info.x + hx[i];
					int ny = info.y + hy[i];

					if (nx < 0 || ny < 0 || nx >= H || ny >= W)
						continue;
					if (check[nx][ny][info.k-1])
						continue;
					
					if (map[nx][ny] == 0) {
						check[nx][ny][info.k-1] = true;
						queue.add(new Info(nx, ny, info.k - 1, info.cnt+1));
					}
				}
			}
		}
		return -1;
	}

	static class Info {
		int x;
		int y;
		int k;
		int cnt;

		Info(int x, int y, int k, int cnt) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}
}
