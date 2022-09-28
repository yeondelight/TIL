import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1011() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dist = y - x;
			int max = (int) Math.sqrt(dist);
			if (max == Math.sqrt(dist)) {
				sb.append(2 * max - 1);
			} else if (dist <= max * max + max){
				sb.append(2 * max);
			} else {
				sb.append(2 * max + 1);
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1011();
	}
}
