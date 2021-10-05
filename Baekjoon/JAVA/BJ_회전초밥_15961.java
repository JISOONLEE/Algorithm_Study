import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_회전초밥_15961 {
	static int N, d, k, c;
	static int[] arr;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		visited = new int[d+1];
		System.out.println(solve());
	}
	private static int solve() {
		int cnt = 0;
		for(int i=0;i<k;i++) {
			if(visited[arr[i]] == 0) 
				cnt++;
			visited[arr[i]]++;
		}
		int max = cnt;
		
		for(int i=1;i<N;i++) {
			if(max<=cnt) {
				if(visited[c] == 0)
					max = cnt+1;
				else
					max = cnt;
			}
			visited[arr[i-1]]--;
			if(visited[arr[i-1]] == 0) cnt--;
			if(visited[arr[(i+k-1)%N]] == 0) cnt++;
			visited[arr[(i+k-1)%N]]++;
		}
		
		return max;
	}
}
