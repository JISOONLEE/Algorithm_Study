import java.util.Scanner;

public class BJ_설탕배달_2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result=0;
		while(true) {
			if(N%5==0) {
				System.out.println(N/5+result);
				break;
			}
			else if(N<0) {
				System.out.println(-1);
				break;
			}
			N=N-3;
			result++;
		}
	}

}
