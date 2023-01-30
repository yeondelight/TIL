import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1535() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] L = new int[N];		// 체력
		int[] J = new int[N];		// 기쁨

		int maxL = 100;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[i] = i만큼의 체력으로 얻을 수 있는 최대 기쁨
		int[] dp = new int[maxL];
		for (int i = 0; i < N; i++) {
			for (int j = maxL-1; j >= L[i]; j--) {
				// i번째 사람과 악수를 했을 떄
				// 체력이 음수가 되지 않으면 최댓값 갱신
				dp[j] = Math.max(J[i] + dp[j - L[i]], dp[j]);
			}
		}
		
		System.out.println(dp[maxL-1]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1535();
	}
}
