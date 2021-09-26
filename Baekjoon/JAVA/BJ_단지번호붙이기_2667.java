import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_단지번호붙이기_2667 {
	static int N;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		int apt=2;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					dfs(i, j, apt, 1);
					apt++;
				}
			}
		}
		int[] count = new int[apt];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] > 0) {
					count[map[i][j]]++;
				}
			}
		}
		Arrays.sort(count);
		
		System.out.println(apt-2);
		for(int i=0;i<apt;i++) {
			if(count[i]>0)
				System.out.println(count[i]);
		}
	}
	
	private static void dfs(int x, int y, int num, int cnt) {
		map[x][y] = num;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			if(map[nx][ny] == 1) {
				dfs(nx, ny, num, cnt+1);
			}
		}
		
	}
}
