import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int diff;
	public static int[] num;
	public static int[] ans;
	public static boolean[] check;
	
	public void backtracking(int idx, int len) {
		if (len == N) {
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(ans[i] - ans[i+1]);
			}
			diff = Math.max(sum, diff);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				check[i] = true;
				ans[len] = num[i];
				backtracking(i + 1, len + 1);
				check[i] = false;
			}
		}
	}

	public void sol_10819() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N+1];
		ans = new int[N];
		check = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i+1] = Integer.parseInt(st.nextToken());
		}
		
		backtracking(0, 0);
		System.out.println(diff);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_10819();
	}
}
