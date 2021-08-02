import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1244 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()+1;
		int[] arr = new int[n];

		for (int i = 1; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int gen = sc.nextInt();
			int idx = sc.nextInt();

			if (gen == 1) {
				for (int j = idx; j < n; j += idx) {
					arr[j] ^= 1;
				}
			} else if (gen == 2) {
				int lIdx = idx-1;
				int rIdx = idx+1;
				while (true) {
					if (lIdx < 1 || rIdx >=n)
						break;
					if (arr[lIdx] != arr[rIdx])
						break;
					lIdx--;
					rIdx++;
				}
				lIdx++;
				rIdx--;
				
				while(lIdx <= rIdx) {
					arr[lIdx] ^= 1;
					lIdx++;
				}

			}
		}
		for (int i=1;i<n;i++) {
			System.out.print(arr[i] + " ");
			if(i%20 == 0)
				System.out.println();
		}
	}

}
