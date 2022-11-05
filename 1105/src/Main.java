import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static int N;
	public static int[] ans;
	public static boolean[] checked;
	public static StringBuilder sb;
	
	public void backtracking(int len) {
		if (len == N) {
			for (int i = 0; i < N; i++) {
				sb.append(ans[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!checked[i]) {
				checked[i] = true;
				ans[len] = i;
				backtracking(len+1);
				checked[i] = false;
			} else {
				continue;
			}
		}
	}
	
	public void sol_10974() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ans = new int[N];
		checked = new boolean[N+1];
		sb = new StringBuilder();
		
		backtracking(0);
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_10974();
	}
}
