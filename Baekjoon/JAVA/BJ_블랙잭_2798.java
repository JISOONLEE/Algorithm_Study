package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_블랙잭_2798 {
	static int N;
	static int M;
	static int[] arr;
	static int[] numbers;
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		numbers = new int[3];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		combination(0, 0);
		System.out.println(result);
	}

	private static void combination(int cnt, int start) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += arr[numbers[i]];
			}
			if (sum <= M)
				result = Math.max(result, sum);
			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}
