import java.util.Scanner;
// 잘 모르겠음
public class BJ_직사각형을만드는방법_8320 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		for(int i=1;i<=N;i++) {
			for(int j=i;j*i<=N;j++) {
				count++;
			}
		}
		System.out.println(count);
	}

}
