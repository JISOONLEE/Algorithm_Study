package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 번호: 4963
 * 이름: 섬의 개수(dfs)
 * 풀이방법: DFS
 * 시간: 20분
 * 
 * 풀이방법: BFS
 * 시간: 40분
 * */
public class BJ_섬의개수_4963 {
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[][] map;
	static int w;
	static int h;
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			w = sc.nextInt();
 			h = sc.nextInt();
 			
 			if(w == 0 && h == 0) break;
 			
 			map = new int[h][w];
 			for(int i=0;i<h;i++) {
 				for(int j=0;j<w;j++) {
 					map[i][j] = sc.nextInt();
 				}
 			}
 			
 			int result=0;
 			for(int i=0;i<h;i++) {
 				for(int j=0;j<w;j++) {
 					if(map[i][j] == 1) {
 						bfs(i, j);
 						result++;
 					}
 				}
 			}
 			System.out.println(result);
		}
	}
	
	private static void dfs(int x, int y) {
		map[x][y] = 0;
		
		for(int i=0;i<8;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<h && ny>=0 && ny<w) {
				if(map[nx][ny] == 1)
					dfs(nx, ny);
			}
		}
	}
	
	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));
		map[x][y] = 0;
		
		while(!queue.isEmpty()) {
			Point pt = queue.poll();
			
			for(int i=0;i<8;i++) {
				int nx = pt.x+dx[i];
				int ny = pt.y+dy[i];
				
				if(nx>=0 && nx<h && ny>=0 && ny<w) {
					if(map[nx][ny] == 1) {
						queue.add(new Point(nx, ny));
						map[nx][ny] = 0;
					}
				}
			}
		}
	}
}
