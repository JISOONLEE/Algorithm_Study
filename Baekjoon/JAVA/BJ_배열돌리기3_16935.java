package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_배열돌리기3_16935 {
	static int N;
	static int M;
	static int R;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num == 1)
				one_cal();
			else if (num == 2)
				two_cal();
			else if (num == 3)
				three_cal();
			else if (num == 4)
				four_cal();
			else if (num == 5)
				five_cal();
			else if (num == 6)
				six_cal();
			else
				System.out.println("잘못 입력이 들어왔습니다.");
		}
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				System.out.print(arr[j][k] + " ");
			}
			System.out.println();
		}
	}

	static void one_cal() { // 상하 반전
		int[][] temp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[N - i - 1][j];
			}
		}
		arr = temp;
	}

	static void two_cal() { // 좌우 반전
		int[][] temp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][M - j - 1];
			}
		}
		arr = temp;
	}

	static void three_cal() { // 오른쪽으로 90도 회전
		int[][] temp = new int[M][N];

		int k = N - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[j][k] = arr[i][j];
			}
			k--;
		}
		int tmp = N;
		N = M;
		M = tmp;

		arr = temp;
	}

	static void four_cal() { // 왼쪽으로 90도 회전
		int[][] temp = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[M - j - 1][i] = arr[i][j];
			}
		}

		int tmp = N;
		N = M;
		M = tmp;

		arr = temp;
	}

	static void five_cal() { // 위치 이동
		int[][] temp = new int[N][M];

		for (int i = 0; i < N / 2; i++) { // 1->2
			for (int j = 0; j < M / 2; j++) {
				temp[i][M / 2 + j] = arr[i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) { // 2->3
			for (int j = M / 2; j < M; j++) {
				temp[N / 2 + i][j] = arr[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) { // 3->4
			for (int j = M / 2; j < M; j++) {
				temp[i][j - M / 2] = arr[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) { // 4->1
			for (int j = 0; j < M / 2; j++) {
				temp[i - N / 2][j] = arr[i][j];
			}
		}

		arr = temp;
	}

	static void six_cal() { // 위치 이동
		int[][] temp = new int[N][M];

		for (int i = 0; i < N / 2; i++) { // 1->4
			for (int j = 0; j < M / 2; j++) {
				temp[N / 2 + i][j] = arr[i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) { // 2->1
			for (int j = M / 2; j < M; j++) {
				temp[i][j - M / 2] = arr[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) { // 3->2
			for (int j = M / 2; j < M; j++) {
				temp[i - N / 2][j] = arr[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) { // 4->3
			for (int j = 0; j < M / 2; j++) {
				temp[i][j + M / 2] = arr[i][j];
			}
		}

		arr = temp;
	}
}
