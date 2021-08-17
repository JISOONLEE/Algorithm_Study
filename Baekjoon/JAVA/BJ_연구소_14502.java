package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_연구소_14502 {
	private static final int LinkedList = 0;
	static int N;
	static int M;
	static int[][] map;
	static int[][] copyMap;
	static int[][] virusMap;
	static int result;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copyMap[i][j] = map[i][j];
			}
		}
//		System.out.println(Arrays.deepToString(copyMap));
		wall(0);
		
		bw.write(result + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void wall(int cnt) {
		if(cnt == 3) {
//			System.out.println(Arrays.deepToString(copyMap));
			virusSpread();
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j] == 0) {
					copyMap[i][j] = 1;
					wall(cnt+1);
					copyMap[i][j] = 0;
				}
			}
		}
	}
	private static void virusSpread() {
		LinkedList<Point> list = new LinkedList<>();

		virusMap = new int[N][M];
		for(int i=0;i<N;i++) { 
			for(int j=0;j<M;j++) {
				virusMap[i][j] = copyMap[i][j];
				if(virusMap[i][j] == 2)
					list.add(new Point(i, j));
			}
		}
		
		while(!list.isEmpty()) {
			int x = list.peek().x;
			int y = list.peek().y;
			list.poll();
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					if(virusMap[nx][ny] == 0) {
						virusMap[nx][ny] = 2;
						list.add(new Point(nx, ny));
					}
				}
			}
		}
		
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(virusMap[i][j] == 0)
					sum++;
			}
		}
		result = Math.max(result, sum);
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
