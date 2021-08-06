package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 번호: 1759
 * 이름: 암호만들기
 * 풀이방법: 조합으로 문자의 종류를 만든다음에 조건 판별하기
 * 시간: 40분
 * */
public class BJ_암호만들기_1759 {
	static int len;
	static char[] result;
	static int cnt;
	static char[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		len = Integer.parseInt(str[0]);
		cnt = Integer.parseInt(str[1]);

		result = new char[len];
		arr = new char[cnt];
		str = br.readLine().split(" ");
		for (int i = 0; i < cnt; i++) {
			arr[i] = str[i].charAt(0);
		}
		Arrays.sort(arr);
		combination(0, 0);
		System.out.println(sb);
	}

	private static void combination(int N, int start) {
		if (N == len) {
			int v = 0; // 모음
			int c = 0; // 자음
			for (int i = 0; i < len; i++) {
				if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
					v++;
				} else {
					c++;
				}

			}
			if (v >= 1 && c >= 2) {
				for (int i = 0; i < len; i++) {
					sb.append(result[i]);
				}
				sb.append('\n');
			}
			return;
		}
		for (int i = start; i < arr.length; i++) {
			result[N] = arr[i];
			combination(N + 1, i + 1);
		}
	}

}
