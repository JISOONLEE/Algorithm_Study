package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_연구소3_17142 {
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
				if (map[i][j] == 1) {
					virusMap[i][j] = -2;
				} else if(map[i][j] == 2) {
					virusMap[i][j] = -3;
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
					if(virusMap[nx][ny] == -3) {
						virusMap[nx][ny] = -4;
						queue.add(new Point(nx, ny, time+1));
					}
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
		
		if (!check) {
			if (max < 0)
				result = 0;
			else {
				result = Math.min(max, result);
			}
		}
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


======================================================================================================================
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_연구소3_17142 {
	static int N, M;
	static int[][] map;
	static ArrayList<Point> virusList;
	static Point[] virus;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int result;
	static class Point {
		int x, y, time;
		Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		virus = new Point[M];
		virusList = new ArrayList<>();
		int zeroCnt = 0;
		result = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virusList.add(new Point(i, j, 0));
				} else if(map[i][j] == 0) {
					zeroCnt++;
				}
			}
		}
		result = Integer.MAX_VALUE;
		
		if(zeroCnt == 0) {
			System.out.println(0);
		} else {
			comb(0, 0, zeroCnt);
			
			if(result == Integer.MAX_VALUE)
				System.out.println(-1);
			else {
				System.out.println(result);
			}
		}
	}
	
	private static void comb(int cnt, int start, int zeroCnt) {
		if(cnt == M) {
			spreadVirus(zeroCnt);
			return;
		}
		for(int i=start;i<virusList.size();i++) {
			virus[cnt] = virusList.get(i);
			comb(cnt+1, i+1, zeroCnt);
		}
	}
	
	private static void spreadVirus(int zeroCnt) {
		Queue<Point> queue = new LinkedList<Point>();
		boolean[][] visited = new boolean[N][N];
		
		for(int i=0;i<M;i++) {
			Point p = virus[i];
			queue.add(p);
			visited[p.x][p.y]= true; 
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx<0 || nx >=N || ny<0 || ny>=N) continue;
				if(visited[nx][ny] || map[nx][ny] == 1) continue;
				
				if(map[nx][ny] == 0) zeroCnt--;
				
				if(zeroCnt <= 0) {
					result = Math.min(result, p.time+1);
					return;
				}
				
				visited[nx][ny] = true;
				queue.add(new Point(nx, ny, p.time+1));
			}
		}
	}
}
