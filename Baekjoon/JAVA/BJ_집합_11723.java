import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 시간 초과-> StringBuilder로 해결
public class BJ_집합_11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		boolean[] S = new boolean[21];
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			
			if(op.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				S[num] = true;
			}
			else if(op.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if(S[num])
					sb.append(1+"\n");
				else
					sb.append(0+"\n");
			}
			else if(op.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				S[num] = false;
			}
			else if(op.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				S[num] = S[num]?false:true;
			}
			else if(op.equals("all")) {
				for(int j=1;j<=20;j++) {
					S[j] = true;
				}
			}
			else if(op.equals("empty")) {
				S = new boolean[21];
			}
		}
		System.out.println(sb.toString());
	}

}
