package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 번호: 1012번
 * 이름: 유기농 배추
 * 풀이방법: DFS
 * 풀이시간: 30분
 * 
 * 풀이방법: BFS
 * 풀이시간: 1시간 (이론 찾아보고 코드 작성)
 * */

public class BJ_유기농배추_1012 {
	static int[][] map;
	static int m;
	static int n;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] check;

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			int result = 0;

			map = new int[m][n];
			check = new boolean[m][n];
			for (int i = 0; i < cnt; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
						// dfs(i, j);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

	private static void dfs(int x, int y) {
		map[x][y] = 0;

		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
				if (map[nx][ny] == 1)
					dfs(nx, ny);
			}
		}
	}

	// 메모리 초과 문제 -> int[] 배열이 아닌 클래스 사용했더니 성공
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x,y));
		map[x][y] = 0;
		
		while (!q.isEmpty()) {
			Point point = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];

				if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
					continue;
				}
				if (map[nx][ny] == 1) {
					q.add(new Point(nx, ny));
					map[nx][ny] = 0;
				}
			}
		}
	}
}
