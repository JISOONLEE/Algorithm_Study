package IM_BJ_DIFFICULTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_방배정_13300 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K= Integer.parseInt(st.nextToken());
		int[][] arr = new int[6][2];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			arr[grade-1][gen]++;
		}
		
		int result = 0;
		for(int i=0;i<6;i++) {
			if(arr[i][0]>0 || arr[i][1]>0) {
				result += (arr[i][0]/K);
				result += (arr[i][1]/K);
				if(arr[i][0]%K!=0)
					result++;
				if(arr[i][1]%K!=0)
					result++;
			} else
				continue;
		}
		System.out.println(result);
	}

}
