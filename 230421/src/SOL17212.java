import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class SOL17212 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N;
	public int[] dp;
	public int[] coins = {7, 5, 2, 1};
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
	}
	
	public void solution() {
		
		dp = new int[N < 7 ? 8 : N+1];
		for (int c : coins) {
			dp[c] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			if (dp[i] == 1) {
				continue;
			}
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int c : coins) {
				if (i - c > 0) {
					pq.offer(dp[i-c] + 1);
				}
			}
			dp[i] = pq.poll();
		}
	}
	
	public void print() {
		System.out.println(dp[N]);
	}
}
