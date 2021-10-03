import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_보급로_1249 {
	static int N;
	static int[][] map;
	static int[][] rmap;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int result;
	
	static class Point implements Comparable<Point>{
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

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			rmap = new int[N][N];
			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
					rmap[i][j] = Integer.MAX_VALUE;
				}
			}
			visited = new boolean[N][N];
			result = Integer.MAX_VALUE;
			bfs(0,0, map[0][0]);
			System.out.println("#"+tc+" "+result);
		}
	}
	private static void bfs(int x, int y, int value) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(x, y, value));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x == N-1 && p.y == N-1) {
				result = Math.min(result, p.weight);
			}
			
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				
				int wgt = p.weight+map[nx][ny];
				if(wgt < rmap[nx][ny]) {
					rmap[nx][ny] = wgt;
					queue.add(new Point(nx, ny, wgt));
				}
			}
		}
	}
}
