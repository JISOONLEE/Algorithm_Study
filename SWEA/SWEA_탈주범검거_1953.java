package WEBEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_탈주범검거_1953 {
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	private static class Point {
		int x, y;
		int dir;
		int time;
		Point(int x, int y, int dir, int time) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1;tc<=TC;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(R,C, map[R][C]);
			
			int result = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visited[i][j])
						result++;
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
	private static void bfs(int x, int y, int dir) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x, y, dir, 1));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int pDir = p.dir;
			if(p.time>=L) return;

			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(map[nx][ny] == 0 || visited[nx][ny]) continue;
				
				int nDir = map[nx][ny];
				
				switch (i) {
				case 0:// 상
					if(pDir == 1 || pDir==2 || pDir == 4 || pDir == 7) {
						if(nDir == 1 || nDir == 2 || nDir == 5 || nDir==6) {
							queue.offer(new Point(nx, ny, map[nx][ny], p.time+1));
							visited[nx][ny] = true;
						}
					}
					break;
				case 1://우
					if(pDir == 1 || pDir == 3 || pDir == 4 || pDir == 5) {
						if(nDir == 1 || nDir == 3 || nDir == 6 || nDir==7) {
							queue.offer(new Point(nx, ny, map[nx][ny], p.time+1));
							visited[nx][ny] = true;
						}
					}
					break;
				case 2: // 하
					if(pDir == 1 || pDir == 2 || pDir == 5 || pDir == 6) {
						if(nDir == 1 || nDir == 2 || nDir == 4 || nDir==7) {
							queue.offer(new Point(nx, ny, map[nx][ny], p.time+1));
							visited[nx][ny] = true;
						}
					}
					break;
				case 3://좌
					if(pDir == 1 || pDir == 3 || pDir == 6 || pDir == 7) {
						if(nDir == 1 || nDir == 3 || nDir == 4 || nDir==5) {
							queue.offer(new Point(nx, ny, map[nx][ny], p.time+1));
							visited[nx][ny] = true;
						}
					}
					break;
				default:
					break;
				}
			}
		}
	}
	
	static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    switch (map[i][j]) {
                    case 1:
                        System.out.print("┼ ");
                        break;
                    case 2:
                        System.out.print("│ ");
                        break;
                    case 3:
                        System.out.print("─ ");
                        break;
                    case 4:
                        System.out.print("└ ");
                        break;
                    case 5:
                        System.out.print("┌ ");
                        break;
                    case 6:
                        System.out.print("┐ ");
                        break;
                    case 7:
                        System.out.print("┘ ");
                        break;
                    default:
                        System.out.print("○ ");
                    }
                } else
                    System.out.print("X ");
            }
            System.out.println();
        }
    }
}
