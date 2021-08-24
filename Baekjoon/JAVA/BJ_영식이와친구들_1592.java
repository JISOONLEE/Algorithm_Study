import java.io.BufferedReader;
import java.util.Scanner;

public class BJ_영식이와친구들_1592 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		int[] arr = new int[N];
		int count = 0;
		int idx = 0;
		while (true) {
			arr[idx]++;
			if (arr[idx] == M) {
				break;
			}
			if (arr[idx] % 2 == 0) {
				if (idx - L < 0)
					idx = N + (idx - L);
				else
					idx -= L;
			} else {
				if (idx + L >= N)
					idx = (idx + L) - N;
				else
					idx += L;
			}
			count++;
		}
		System.out.println(count);
	}

}
