import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_나는야포켓몬마스터이다솜_1620 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> map = new HashMap<>();
		String[] str = new String[N + 1];
		for (int i = 1; i <= N; i++) {
			str[i] = br.readLine();
			map.put(str[i], i);
		}

		for (int i = 0; i < M; i++) {
			String q = br.readLine();
			if (Character.isDigit(q.charAt(0)))
				sb.append(str[Integer.parseInt(q)] + "\n");
			else
				sb.append(map.get(q) + "\n");
		}
		System.out.println(sb.toString());
	}

}
