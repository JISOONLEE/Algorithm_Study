import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_ATM_11399 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] str = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(arr);
		int sum=0;
		int num = 0;
		for(int i=0;i<N;i++) {
			num += arr[i];
			sum += num;
		}
		System.out.println(sum);
	}

}
