package WEBEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_맥주마시면서걸어가기_9205 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int INF = Integer.MAX_VALUE;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Point> list = new ArrayList<>();
			boolean[][] dis = new boolean[N + 2][N + 2];

			for (int i = 0; i < N + 2; i++) {
				String[] str = br.readLine().split(" ");
				int x = Integer.parseInt(str[0]);
				int y = Integer.parseInt(str[1]);
				list.add(new Point(x, y));
			}

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if(i==j) continue;
					int dist = Math.abs(list.get(i).x - list.get(j).x) + Math.abs(list.get(i).y - list.get(j).y);
					if (dist <= 1000)
						dis[i][j] = true;
				}
			}

			for (int k = 0; k < N + 2; k++) {
				for (int i = 0; i < N + 2; i++) {
					if (i == k)
						continue;
					for (int j = 0; j < N + 2; j++) {
						if (i == k || k == j)
							continue;
						if(!dis[i][j]) {
							if(dis[i][k] && dis[k][j]) {
								dis[i][j] = true;
							}
						}
					}
				}
			}
			if (dis[0][N + 1])
				System.out.println("happy");
			else
				System.out.println("sad");
		}
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
