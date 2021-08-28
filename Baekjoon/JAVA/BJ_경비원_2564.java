package IM_BJ_DIFFICULTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_경비원_2564 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[][] stores = new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			stores[i][0] = Integer.parseInt(st.nextToken());
			stores[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int[] dong = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		
		int result = 0;
		for(int i=0;i<N;i++) {
			if(dong[0] == 1) {
				if(stores[i][0] == 1) result+=Math.abs(dong[1] - stores[i][1]);
				else if(stores[i][0] == 2) 
					result+= (H+(Math.min(dong[1]+stores[i][1], W-dong[1] +W-stores[i][1])));
				else if(stores[i][0] == 3) 
					result+=dong[1]+stores[i][1];
				else
					result+=W-dong[1]+stores[i][1];
			} else if(dong[0] == 2) {
				if(stores[i][0] == 2) result+=Math.abs(dong[1] - stores[i][1]);
				else if(stores[i][0] == 1) 
					result+= (H+(Math.min(dong[1]+stores[i][1], W-dong[1] +W-stores[i][1])));
				else if(stores[i][0] == 3) 
					result+=dong[1]+H-stores[i][1];
				else
					result+=W-dong[1]+H-stores[i][1];
			} else if(dong[0] == 3) {
				if(stores[i][0] == 3) result+=Math.abs(dong[1] - stores[i][1]);
				else if(stores[i][0] == 4) 
					result+= (W+(Math.min(dong[1]+stores[i][1], W-dong[1] +W-stores[i][1])));
				else if(stores[i][0] == 1) 
					result+=dong[1]+stores[i][1];
				else
					result+=H-dong[1]+stores[i][1];
			} else {
				if(stores[i][0] == 4) result+=Math.abs(dong[1] - stores[i][1]);
				else if(stores[i][0] == 3) 
					result+= (W+(Math.min(dong[1]+stores[i][1], W-dong[1] +W-stores[i][1])));
				else if(stores[i][0] == 1) 
					result+=dong[1]+W - stores[i][1];
				else
					result+=H-dong[1]+W-stores[i][1];
			}
		}
		System.out.println(result);
	}

}
