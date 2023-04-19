import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL18353 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N;
	public int[] force, dp;
	
	int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws IOException, NumberFormatException {
		N = Integer.parseInt(br.readLine());
		
		force = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = N-1; i >= 0; i--) {
			force[i] = Integer.parseInt(st.nextToken());
		}
	}

	public void solution() {
		dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			int maxIndex = i;
			for (int j = 0; j < i; j++) {
				if (force[j] < force[i] && dp[maxIndex] < dp[j]) {
					maxIndex = j;
				}
			}
			dp[i] = dp[maxIndex] + 1;
			
			ans = Math.max(ans, dp[i]);
		}
	}
	
	public void print() {
		System.out.println(N-ans);
	}
}
