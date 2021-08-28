package IM_BJ_DIFFICULTY;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_자리배정_10157 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] arr;
	static int C;
	static int R;
	static int K;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		K = sc.nextInt();
		arr = new int[R][C];

		if(K <= R*C)
			solve(R - 1, 0);
		else
			System.out.println(0);
	}

	private static void solve(int x, int y) {
		int dir = 0;
		int num = 1;
		arr[x][y] = num;
		while (K != num) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C || arr[nx][ny] !=0) {
				if(dir == 3) dir = 0;
				else dir++;
			} else {
				arr[nx][ny] = ++num;
				x = nx;
				y = ny;
			}
		}
		System.out.println((y+1)+" "+(R-x));
	}
}
