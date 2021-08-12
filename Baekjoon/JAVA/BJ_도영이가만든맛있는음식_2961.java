import java.util.Scanner;

public class BJ_도영이가만든맛있는음식_2961 {
	static int N;
	static int[] sour;
	static int[] bitterness;
	static boolean[] isSelected;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		sour = new int[N];
		bitterness = new int[N];
		isSelected = new boolean[N];
		for (int n = 0; n < N; n++) {
			sour[n] = sc.nextInt();
			bitterness[n] = sc.nextInt();
		}

		subSet(0);
		System.out.println(result);
	}

	static void subSet(int cnt) { // 부분집합 구현
		if (cnt == N) {
			int sSum = 1;
			int bSum = 0;
			boolean check = false; // 공집합인지 체크
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					check = true;
					sSum *= sour[i];
					bSum += bitterness[i];
				}
			}
			if (check) // 공집합이 아니면 결과 도출
				result = Math.min(result, Math.abs(sSum - bSum));
			return;
		}

		isSelected[cnt] = true;
		subSet(cnt + 1);
		isSelected[cnt] = false;
		subSet(cnt + 1);
	}

}
