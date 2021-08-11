package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_비밀이메일_2999 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int R = 0;
		int C = 0;

		for (int i = 1; i < str.length(); i++) {
			if (str.length() % i == 0) {
				if (i <= str.length() / i) {
					R = i;
					C = str.length() / i;
				}
			}
		}
		char[][] arr = new char[R][C];
		int cnt = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[j][i] = str.charAt(cnt);
				cnt++;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
		}
	}

}
