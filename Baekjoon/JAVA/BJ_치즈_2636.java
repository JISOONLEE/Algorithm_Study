import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_치즈_2636 {
	static int H;
	static int W;
	static int[][] map;
	static boolean[][] check;
	static boolean[][] cheese_edge;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		check = new boolean[H][W];
		cheese_edge = new boolean[H][W];
		int cheese_cnt = 0;
		int time = 0;
		for(int h=0;h<H;h++) {
			st= new StringTokenizer(br.readLine());
			for(int w=0;w<W;w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
				if(map[h][w] == 1) cheese_cnt++;
			}
 		}
		int pre_cheese=0;
		while(true) {
			time++;
			bfs();
			pre_cheese = cheese_cnt;
			cheese_cnt -= cheese_remove();
			if(cheese_cnt == 0) {
				break;
			}
		}
		
		System.out.println(time);
		System.out.println(pre_cheese);
	}
	private static int cheese_remove() {
		int cnt = 0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(cheese_edge[i][j]) {
					map[i][j] = 0;
					cnt++;
				}
			}
		}
		check = new boolean[H][W];
		cheese_edge = new boolean[H][W];
		return cnt;
	}
	private static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(0,0));
		check[0][0] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=H || ny>=W) continue;
				if(check[nx][ny]) continue;
				if(map[nx][ny] == 1) {
					check[nx][ny] = true;
					cheese_edge[nx][ny] = true;
				} else {
					check[nx][ny] = true;
					queue.add(new Node(nx, ny));
				}
			}
		}
	}
	
	private static class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
