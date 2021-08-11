package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_배열돌리기4_17406 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;
	static int M;
	static int K;
	static int[][] arr;
	static int[][] info;
	static boolean[] visited;
	static int[] temp;
	static int[][] new_arr;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][M];

		for (int n = 0; n < N; n++) { // 배열 값 가져오기
			for (int m = 0; m < M; m++) {
				arr[n][m] = sc.nextInt();
			}
		}
		info = new int[K][3];
		for (int k = 0; k < K; k++) { // 회전 정보 배열에 저장
			info[k][0] = sc.nextInt();
			info[k][1] = sc.nextInt();
			info[k][2] = sc.nextInt();
//         circle(info[k]);
		}
		visited = new boolean[K]; // 회전 정보 중복 안되도록 boolean문 선언
		temp = new int[K]; // 순서를 저장하기 위한 배열
		result = Integer.MAX_VALUE; // 최소값 구하기위해 max값 넣어주기
		permutation(0);
		System.out.println(result);
	}

	private static void permutation(int cnt) { // 순서를 바꾸는 것이기에 순열
		if (cnt == K) {
			new_arr = new int[N][M];
			// arr 배열 복사, 값이 바뀌기 때문에
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++)
					new_arr[i][j] = arr[i][j];
			}
			// 순서를 저장해둔 temp 배열의 값을 info배열과 매핑해서 회전 정보를 circle에 돌려준다.
			for (int i = 0; i < temp.length; i++) {
				circle(info[temp[i]]);
			}

			int min = Integer.MAX_VALUE;
			// 각 행의 최소값 찾기
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += new_arr[i][j];
				}
				min = Math.min(min, sum);
			}
			// 순서에 따른 최소값 저장
			result = Math.min(result, min);
			return;
		}
		for (int i = 0; i < info.length; i++) {
			if (!visited[i]) { // 갔던 곳이면 가지 않기
				visited[i] = true;
				temp[cnt] = i;
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}

	private static void circle(int[] information) { // 회전하는 함수
		for (int i = 0; i < information[2]; i++) { // 회전하는 라인의 수는 infomation[2]와 같다.
			int x_value = information[0] - information[2] - 1; // 맨처음행을 저장하기위한 변수
			int y_value = information[1] - information[2] - 1;
			int x = x_value + i; // 시작 값 설정, 0, 1이런식으로 증가하기에 점점 가운데 라인으로 들어가서 회전할 수 있도록
			int y = y_value + i;
			int temp = new_arr[x][y]; // 처음 값 저장
			int d = 0;

			while (d < 4) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= (x_value + i) && ny >= (y_value + i) && nx < (information[0] + information[2] - i)
						&& ny < (information[1] + information[2] - i)) { // 범위 체크
					new_arr[x][y] = new_arr[nx][ny];
					x = nx;
					y = ny;
				} else {
					d++; // 만약 범위 체크에서 걸렸다면 회전해줄 차례
				}

			}
			new_arr[information[0] - information[2] - 1 + i][information[1] - information[2] + i] = temp; 
		}
	}
}
