import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_요세푸스문제_1158 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			list.add(i);
		}
		sb.append("<");
		while(!list.isEmpty()) {
			for(int i=0;i<K-1;i++) {
				list.add(list.poll());
			}
			sb.append(list.poll()+", ");
		}
		sb.delete(sb.length()-2, sb.length());
//		sb.deleteCharAt(sb.lastIndexOf(", ")); // 맨뒤의 문자열 찾아서 제거
		sb.append(">");
		System.out.println(sb);
	}

}
