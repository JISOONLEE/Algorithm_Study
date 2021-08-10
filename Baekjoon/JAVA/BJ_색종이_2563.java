import java.util.Scanner;

public class BJ_색종이_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int[][] arr = new int[101][101];
		int result = 0;
		
		// 한칸의 크기는 1이므로
		for(int n=0;n<N;n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			// 색종이가 도화지 밖을 나가는 경우는 없다는 조건이 있으므로
			// 범위체크 안해도 됨
			for(int i = x; i<x+10;i++) { 
				for(int j = y;j<y+10;j++) {
					if(arr[i][j] == 1) // 이미 넓이를 증가했으면 넘어가기
						continue;
					arr[i][j] = 1;
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
