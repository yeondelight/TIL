import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_3474() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			
			while (N/5 > 0) {
				ans += N/5;
				N /= 5;
			}
			
			sb.append(ans).append('\n');			
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_3474();
	}

}
