import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_롤케이크_3985 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int[] cake = new int[L + 1];
		int max = 0;
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			String[] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);

			if (max < end - start) {
				max = end - start;
				idx = i;
			}

			for (int j = start; j <= end; j++) {
				if (cake[j] == 0)
					cake[j] = i;
			}
		}
		Arrays.sort(cake);

		int current = 0;
		int count = 0;
		max = 0;
		int resultIdx = 0;
		for (int i = 1; i <= L; i++) {
			if (cake[i] != 0) {
				if (cake[i] != current) {
					if (max < count) {
						max = count;
						resultIdx = current;
					}
					count=1;
					current = cake[i];
				} else {
					count++;
				}
				if(i==L) { // 마지막에는 count 비교가 안되기에 따로 조건문 삽입
					if (max < count) {
						max = count;
						resultIdx = current;
					}
				}
			}
		}
		System.out.println(idx + "\n" + resultIdx);
	}

}
