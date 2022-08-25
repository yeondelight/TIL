import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_7579() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N+1];
		int[] C = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			C[i] = Integer.parseInt(st.nextToken());
			sum += C[i];
		}
		

		int[] dp = new int[sum+1];				// index의 비용으로 확보 가능한 최대 메모리
		for (int i = 1; i <= N; i++) {			// i는 마지막으로 검사한 앱의 번호
			for (int j = sum; j >= C[i]; j--) {	// j는 비용
				// A[i] 앱을 넣어도 비용이 초과되지 않는다면 최댓값 갱신
				dp[j] = Math.max(A[i] + dp[j-C[i]], dp[j]);
			}
		}
		
		for (int i = 0; i < sum+1; i++) {
			if (dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_7579();
	}
}
