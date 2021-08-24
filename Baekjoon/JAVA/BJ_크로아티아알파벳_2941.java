package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_크로아티아알파벳_2941 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i=0;i<arr.length;i++) {
			if(str.contains(arr[i])) {
				str = str.replace(arr[i], ".");
			}
		}
		System.out.println(str.length());
	}

}
