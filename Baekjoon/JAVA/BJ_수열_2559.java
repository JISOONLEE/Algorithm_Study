package IM_BJ_DIFFICULTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_수열_2559 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = Integer.MIN_VALUE;
		for (int i = 0; i <= N - K; i++) {
			int sum = 0;
			for (int j = i; j < i + K; j++) {
				sum += arr[j];
			}
			result = Math.max(result, sum);
		}
		System.out.println(result);
	}

}
