import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int answer = Integer.MAX_VALUE;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		System.out.println(map[N-1][M-1]);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int q[] = queue.poll();
			int r = q[0];
			int c = q[1];
			
			for(int i=0;i<4;i++) {
				int nx = r + dx[i];
				int ny = c + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny>=M) continue;
				if(visited[nx][ny]) continue;
				if(map[nx][ny] == 0) continue;
				
				visited[nx][ny] = true;
				queue.add(new int[] {nx, ny});
				map[nx][ny] = map[r][c] + 1;
			}
		}
		
	}
}
