import java.util.Scanner;

public class BJ_백설공주와일곱난쟁이_3040 {
	static int[] arr;
	static int[] result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		result = new int[7];
		for(int i=0;i<9;i++) {
			arr[i] = sc.nextInt();
		}
		combination(0, 0);
	}
	private static void combination(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i=0;i<result.length;i++) {
				sum+=result[i];
			}
			if(sum == 100) {
				for(int i=0;i<result.length;i++)
					System.out.println(result[i]);
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			result[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
	}
}
