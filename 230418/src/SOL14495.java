import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL14495 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N;
	public int[] card;
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws IOException, NumberFormatException {
		N = Integer.parseInt(br.readLine());
		
		card = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
	}

	public void solution() {
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			int maxIndex = i;
			for (int j = 0; j < i; j++) {
				if (card[j] < card[i] && dp[maxIndex] < dp[j]) {
					maxIndex = j;
				}
			}
			dp[i] = dp[maxIndex] + 1;
			
			ans = Math.max(ans, dp[i]);
		}
	}
	
	public void print() {
		System.out.println(ans);
	}
}
