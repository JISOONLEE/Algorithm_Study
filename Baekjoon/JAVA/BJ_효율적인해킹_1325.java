import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_효율적인해킹_1325 {
	static int N;
	static int M;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int[] result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++)
			list[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
		}
		result = new int[N+1];
		for(int i=1;i<=N;i++) {
			if(!list[i].isEmpty()) {
				visit = new boolean[N+1];
				bfs(i);
//				dfs(i);
			}
		}
		int maxValue = 0;
		for(int i=1;i<=N;i++) {
			if(result[i]>maxValue) {
				maxValue = result[i];
			}
		}
//		System.out.println(Arrays.toString(sortList));
		
		for(int i=1;i<=N;i++) {
			if(maxValue == result[i]) 
				sb.append(i+" ");
		}
		System.out.println(sb.toString());
	}
	
	private static void bfs(int idx) {
		visit = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(idx);
		visit[idx] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for(int i=0;i<list[num].size();i++) {
				int next = list[num].get(i);
				if(!visit[next]) {
					visit[next] = true;
					result[next]++;
					queue.add(next);
				}
			}
		}
		
	}
	
	private static void dfs(int idx) { //시간초과
		visit[idx] = true;

		for(int next:list[idx]) {
			if(!visit[next]) {
				result[next]++;
				dfs(next);
			}
		}
	}
}
