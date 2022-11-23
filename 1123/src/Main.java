import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public void sol_14659() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] top = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int cnt = 0;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (top[i] < max) {
				cnt++;
			} else {
				max = top[i];
				ans = Math.max(ans, cnt);
				cnt = 0;
			}
		}
		
		ans = Math.max(ans, cnt);
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_14659();
	}
}
