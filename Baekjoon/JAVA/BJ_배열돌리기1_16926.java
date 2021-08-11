package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_배열돌리기1_16926 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		int[][] arr = new int[N][M];

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				arr[n][m] = sc.nextInt();
			}
		}

		int circle = Math.min(N, M)/2; // 회전을 도는 라인 갯수 정리
		for (int r = 0; r < R; r++) {
			for (int i = 0; i < circle; i++) {
				int x = i;
				int y = i;
				int temp = arr[x][y];
				int d = 0;

				while (d < 4) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx >= i && ny >= i && nx < N - i && ny < M - i) {
						arr[x][y] = arr[nx][ny];
						x = nx;
						y = ny;
					} else {
						d++;
					}
				}
				arr[i + 1][i] = temp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
