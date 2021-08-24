import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_나머지_3052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[10];
		
		for(int i=0;i<10;i++) {
			nums[i] = Integer.parseInt(br.readLine()) % 42;
		}
		Arrays.sort(nums);
		int current = -1;
		int count = 0;
		for(int i=0;i<10;i++) {
			if(nums[i] != current) {
				current=nums[i];
				count++;
			}
		}
		System.out.println(count);
	}

}
