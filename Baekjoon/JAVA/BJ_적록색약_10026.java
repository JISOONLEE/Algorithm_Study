import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_적록색약_10026 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] check;
	static char map[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		check = new boolean[N][N];
		int first = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
					dfs(i, j);
					first++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 'G')
					map[i][j] = 'R';
			}
		}
		
		check = new boolean[N][N];
		int second = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
					dfs(i, j);
					second++;
				}
			}
		}
		System.out.println(first+" "+second);
	}
	private static void dfs(int x, int y) {
		int px = x;
		int py = y;
		check[x][y] = true;
		char current = map[x][y];
		
		for(int i=0;i<4;i++) {
			int nx = px+dx[i];
			int ny = py+dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(!check[nx][ny] && map[nx][ny] == current)
					dfs(nx, ny);
			}
		}
	}
}
