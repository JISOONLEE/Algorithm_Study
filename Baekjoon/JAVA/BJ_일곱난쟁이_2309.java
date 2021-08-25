package IM_BJ_DIFFICULTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_일곱난쟁이_2309 {
	static int[] result;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		result = new int[7];
		Arrays.sort(arr);
		comb(0, 0);
	}

	private static void comb(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += result[i];
				if (sum > 100)
					return;
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(result[i]);
				}
				System.exit(0);
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			result[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}
	}
}
