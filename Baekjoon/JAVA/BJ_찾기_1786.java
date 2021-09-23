import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_찾기_1786 {
	// KMP 공부하기
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tLength = text.length, pLength = pattern.length;
		
		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){
	        while(j > 0 && pattern[i] != pattern[j]) {
	        	j = pi[j-1];  
	        }
	        if(pattern[i] == pattern[j]) pi[i] = ++j;
	    }
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0,j=0; i<tLength; ++i) { 
			
			while(j>0 && text[i] != pattern[j]) j = pi[j-1]; 
			
			if(text[i] == pattern[j]) {
				if(j == pLength-1) { 
					cnt++;
					list.add(i-pLength+2); 
					j=pi[j]; 
				}else { 
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		for(int i=0;i<cnt;i++) {
			System.out.print(list.get(i)+" ");
		}
	}

}
