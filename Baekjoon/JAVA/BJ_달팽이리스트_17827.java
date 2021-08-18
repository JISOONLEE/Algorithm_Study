import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_달팽이리스트_17827 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb =new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<V;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		list2.add(list.get(list.size()-1));
		
		for(int i=V;i<N;i++) {
			list2.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num<V)
				sb.append(list.get(num));
			else {
				num = num-V+1;
				sb.append(list2.get(num%(N-V+1)));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
