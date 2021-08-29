package IM_BJ_DIFFICULTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_딱지놀이_14696 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= TC; tc++) {
			int[] aNums = new int[5];
			st = new StringTokenizer(br.readLine());
			int aCnt = Integer.parseInt(st.nextToken());
			for (int i = 0; i < aCnt; i++) {
				aNums[Integer.parseInt(st.nextToken())]++;
			}
			int[] bNums = new int[5];
			st = new StringTokenizer(br.readLine());
			int bCnt = Integer.parseInt(st.nextToken());
			for (int i = 0; i < bCnt; i++) {
				bNums[Integer.parseInt(st.nextToken())]++;
			}

			boolean check = false;
			for (int i = 4; i > 0; i--) {
				if (aNums[i] > bNums[i]) {
					System.out.println('A');
					check = false;
					break;
				} else if (aNums[i] < bNums[i]) {
					System.out.println('B');
					check = false;
					break;
				}
				check = true;
			}
			if (check)
				System.out.println("D");
		}
	}

}
